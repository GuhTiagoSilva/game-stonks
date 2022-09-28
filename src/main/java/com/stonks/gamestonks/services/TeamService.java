package com.stonks.gamestonks.services;

import com.stonks.gamestonks.dto.*;
import com.stonks.gamestonks.models.PlayerModel;
import com.stonks.gamestonks.models.TeamModel;
import com.stonks.gamestonks.models.VacancyModel;
import com.stonks.gamestonks.repositories.PlayerRepository;
import com.stonks.gamestonks.repositories.TeamRepository;
import com.stonks.gamestonks.repositories.VacancyRepository;
import com.stonks.gamestonks.repositories.projections.PlayerAppliedVacancyProjection;
import com.stonks.gamestonks.repositories.projections.TeamGameProjection;
import com.stonks.gamestonks.repositories.projections.TeamProjection;
import com.stonks.gamestonks.services.exceptions.ResourceNotFoundException;
import com.stonks.gamestonks.utils.MailMessageUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    private final VacancyRepository vacancyRepository;

    private final AuthService authService;

    private final PlayerRepository playerRepository;

    private final EmailService emailService;

    private static String htmlBodyMail = MailMessageUtils.getInvitePlayerHtmlMailBody();

    public TeamService(TeamRepository teamRepository,
                       VacancyRepository vacancyRepository,
                       PlayerRepository playerRepository,
                       AuthService authService,
                       EmailService emailService
    ) {
        this.teamRepository = teamRepository;
        this.vacancyRepository = vacancyRepository;
        this.playerRepository = playerRepository;
        this.authService = authService;
        this.emailService = emailService;
    }

    @Transactional(readOnly = true)
    public List<TeamProjection> findAllTeamsWithAvailableVacancies(String gameName, Long yearsOfExperience, LocalDate startDate) {
        List<TeamProjection> teamProjections = teamRepository.findOpenVacanciesForTeams(gameName, startDate, yearsOfExperience);
        return  teamProjections;
    }
    @Transactional
    public void createTeam(TeamDto teamDto) {
        TeamModel teamModel = new TeamModel();
        teamModel.setDescription(teamDto.getDescription());
        teamModel.setName(teamDto.getName());
        teamModel.setVacancy(new VacancyModel(teamDto.getVacancyId()));
        teamRepository.save(teamModel);
    }

    @Transactional(readOnly = true)
    public List<TeamGameProjection> findAllTeams(String gameName, Long yearsOfExperience) {
        return teamRepository.findAllTeams(gameName, yearsOfExperience);
    }
    @Transactional(readOnly = true)
    public TeamDto findById(Long id) {
        TeamModel team = teamRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Entity Not Found: "
                + id));

        VacancyModel vacancyModel = vacancyRepository.findById(team.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Entity Not Found: "
                        + id));
        VacancyDto vacancyDto = new VacancyDto(vacancyModel);
        return new TeamDto(team, vacancyDto);
    }

    @Transactional(readOnly = true)
    public List<PlayerAppliedVacancyProjection> findAllAppliedPlayers() {
        PlayerModel playerModel = authService.authenticated();
        return playerRepository.findAllAppliedPlayers(playerModel.getId());
    }

    @Transactional
    public void inviteTeamToJoinTheTeam(Long playerId) {

        PlayerModel userAuthenticated = authService.authenticated();

        PlayerModel playerModel = playerRepository.findById(playerId).orElseThrow(() -> new ResourceNotFoundException("Player not found"));

        MessageDto messageDto = MessageDto
                .builder()
                .senderName(userAuthenticated.getFirstName() + " " + userAuthenticated.getLastName())
                .receiverName(playerModel.getEmail())
                .message("Message")
                .build();

        htmlBodyMail = htmlBodyMail.replaceAll("_userEmail_", playerModel.getFirstName() + " " + playerModel.getLastName());
        EmailDetailsDto emailDetailsDto = EmailDetailsDto.builder()
                .msgBody(htmlBodyMail)
                .recipient(playerModel.getEmail())
                .subject(userAuthenticated.getFirstName() + " " + userAuthenticated.getLastName() + " gostaria de conversar com você !!!")
                .build();

        emailService.sendMail(emailDetailsDto, messageDto.getSenderName());
    }

}
