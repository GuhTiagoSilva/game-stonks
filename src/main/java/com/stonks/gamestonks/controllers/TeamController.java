package com.stonks.gamestonks.controllers;

import com.stonks.gamestonks.dto.TeamDto;
import com.stonks.gamestonks.repositories.projections.TeamGameProjection;
import com.stonks.gamestonks.repositories.projections.TeamProjection;
import com.stonks.gamestonks.services.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createTeam(@RequestBody TeamDto teamDto) {
        teamService.createTeam(teamDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/vacancies")
    public List<TeamProjection> findOpenVacanciesForTeams(@RequestParam(required = false) String gameName, @RequestParam(required = false) Long yearsOfExperience, @RequestParam(required = false) LocalDate startDate) {
        return teamService.findAllTeamsWithAvailableVacancies(gameName, yearsOfExperience, startDate);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<TeamGameProjection> findAllTeams(@RequestParam(required = false) String gameName, @RequestParam(required = false) Long yearsOfExperience) {
        return teamService.findAllTeams(gameName, yearsOfExperience);
    }

}
