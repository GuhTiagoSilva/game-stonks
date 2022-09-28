package com.stonks.gamestonks.services;

import com.stonks.gamestonks.dto.EmailDetailsDto;
import com.stonks.gamestonks.enums.ContractType;
import com.stonks.gamestonks.enums.VacancyStatus;
import com.stonks.gamestonks.models.*;
import com.stonks.gamestonks.pk.PlayerTeamPK;
import com.stonks.gamestonks.repositories.*;
import com.stonks.gamestonks.services.exceptions.BusinessException;
import com.stonks.gamestonks.services.exceptions.ResourceNotFoundException;
import com.stonks.gamestonks.utils.MailMessageUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerTeamVacancyService {

    private final PlayerTeamVacancyRepository playerTeamVacancyRepository;

    private final TeamRepository teamRepository;

    private final PlayerRepository playerRepository;

    private final VacancyRepository vacancyRepository;

    private final GameRepository gameRepository;

    private final EmailService emailService;

    private static String htmlBodyMail = MailMessageUtils.getDefaultHtmlMailBody();

    private final AuthService authService;

    public PlayerTeamVacancyService(PlayerTeamVacancyRepository playerTeamVacancyRepository,
                                    TeamRepository teamRepository,
                                    PlayerRepository playerRepository,
                                    VacancyRepository vacancyRepository,
                                    EmailService emailService,
                                    GameRepository gameRepository,
                                    AuthService authService
    ) {
        this.playerTeamVacancyRepository = playerTeamVacancyRepository;
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.vacancyRepository = vacancyRepository;
        this.emailService = emailService;
        this.authService = authService;
        this.gameRepository = gameRepository;
    }

    @Transactional
    public void applyToVacancy(Long vacancyId, Long teamId, Long gameId) {



        VacancyModel vacancyModel = vacancyRepository.findById(vacancyId).orElseThrow(() -> new ResourceNotFoundException("Vacancy Not Found"));
        PlayerModel playerModel = authService.authenticated();
        TeamModel teamModel = teamRepository.findById(teamId).orElseThrow(() -> new ResourceNotFoundException("Team Not Found"));
        GameModel gameModel = gameRepository.findById(gameId).orElseThrow(() -> new ResourceNotFoundException("Game not found"));

        PlayerTeamPK playerTeamPK = new PlayerTeamPK();
        playerTeamPK.setPlayer(playerModel);
        playerTeamPK.setVacancyModel(vacancyModel);
        playerTeamPK.setTeam(teamModel);
        playerTeamPK.setGameModel(gameModel);

        if (playerTeamVacancyRepository.existsById(playerTeamPK))
            throw new BusinessException("This player is already in this vacancy.");

        vacancyModel.setVacancyStatus(VacancyStatus.PENDING);
        vacancyRepository.save(vacancyModel);

        htmlBodyMail = htmlBodyMail.replaceAll("_userEmail_", playerModel.getEmail());
        htmlBodyMail = htmlBodyMail.replaceAll("_vacancyName_", vacancyModel.getName());
        htmlBodyMail = htmlBodyMail.replaceAll("userId", String.valueOf(playerModel.getId()));

        htmlBodyMail = htmlBodyMail.replaceAll("vacancyId", String.valueOf(vacancyId));
        htmlBodyMail = htmlBodyMail.replaceAll("teamId", String.valueOf(teamId));

        EmailDetailsDto emailDetailsDto = EmailDetailsDto.builder()
                .msgBody(htmlBodyMail)
                .recipient(vacancyModel.getAuthor().getEmail())
                .subject("O jogador: " + playerModel.getEmail() + " se interessou pela vaga: " + vacancyModel.getName() + "!!!")
                .build();

        PlayerTeamVacancyModel playerTeamVacancyModel = new PlayerTeamVacancyModel();
        playerTeamVacancyModel.setPrimaryKey(playerTeamPK);
        playerTeamVacancyModel.setContractType(ContractType.FULLTIME);

        emailService.sendMail(emailDetailsDto);
        playerTeamVacancyRepository.save(playerTeamVacancyModel);
    }

}
