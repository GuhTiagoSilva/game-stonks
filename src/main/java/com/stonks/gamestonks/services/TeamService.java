package com.stonks.gamestonks.services;

import com.stonks.gamestonks.dto.TeamDto;
import com.stonks.gamestonks.dto.TeamRequestSearchDto;
import com.stonks.gamestonks.models.TeamModel;
import com.stonks.gamestonks.models.VacancyModel;
import com.stonks.gamestonks.repositories.TeamRepository;
import com.stonks.gamestonks.repositories.projections.TeamGameProjection;
import com.stonks.gamestonks.repositories.projections.TeamProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
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

}
