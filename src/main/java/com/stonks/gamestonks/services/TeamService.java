package com.stonks.gamestonks.services;

import com.stonks.gamestonks.dto.TeamDto;
import com.stonks.gamestonks.dto.VacancyDto;
import com.stonks.gamestonks.models.TeamModel;
import com.stonks.gamestonks.models.VacancyModel;
import com.stonks.gamestonks.repositories.TeamRepository;
import com.stonks.gamestonks.repositories.VacancyRepository;
import com.stonks.gamestonks.repositories.projections.TeamGameProjection;
import com.stonks.gamestonks.repositories.projections.TeamProjection;
import com.stonks.gamestonks.services.exceptions.ResourceNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    private final VacancyRepository vacancyRepository;

    public TeamService(TeamRepository teamRepository, VacancyRepository vacancyRepository) {
        this.teamRepository = teamRepository;
        this.vacancyRepository = vacancyRepository;
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
}
