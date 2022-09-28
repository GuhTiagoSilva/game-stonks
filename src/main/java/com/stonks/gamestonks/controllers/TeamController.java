package com.stonks.gamestonks.controllers;

import com.stonks.gamestonks.dto.InvitePlayerDto;
import com.stonks.gamestonks.dto.MessageDto;
import com.stonks.gamestonks.dto.TeamDto;
import com.stonks.gamestonks.repositories.projections.PlayerAppliedVacancyProjection;
import com.stonks.gamestonks.repositories.projections.PlayersOpenToWorkProjection;
import com.stonks.gamestonks.repositories.projections.TeamGameProjection;
import com.stonks.gamestonks.repositories.projections.TeamProjection;
import com.stonks.gamestonks.services.PlayerService;
import com.stonks.gamestonks.services.TeamService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    private final PlayerService playerService;

    public TeamController(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @ApiOperation(value = "Criar time")
    @PreAuthorize("hasAnyRole('TEAM')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createTeam(@RequestBody TeamDto teamDto) {
        teamService.createTeam(teamDto);
    }

    @ApiOperation(value = "Obter todos os times que possuem vagas abertas")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('PLAYER')")
    @GetMapping("/vacancies")
    public List<TeamProjection> findOpenVacanciesForTeams(@RequestParam(required = false) String gameName, @RequestParam(required = false) Long yearsOfExperience, @RequestParam(required = false) LocalDate startDate) {
        return teamService.findAllTeamsWithAvailableVacancies(gameName, yearsOfExperience, startDate);
    }

    @ApiOperation(value = "Obter todos os times e os games que jogam")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('TEAM', 'PLAYER')")
    @GetMapping
    public List<TeamGameProjection> findAllTeams(@RequestParam(required = false) String gameName, @RequestParam(required = false) Long yearsOfExperience) {
        return teamService.findAllTeams(gameName, yearsOfExperience);
    }

    @ApiOperation(value = "Obter time por ID")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('TEAM', 'PLAYER')")
    @GetMapping("/{id}")
    public TeamDto findById(@PathVariable Long id) {
        return teamService.findById(id);
    }

    @ApiOperation(value = "Obter todos os jogadores que aplicaram para uma vaga de um time")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('TEAM')")
    @GetMapping("/appliedPlayers")
    public List<PlayerAppliedVacancyProjection> findAllAppliedPlayers() {
        return teamService.findAllAppliedPlayers();
    }

    @ApiOperation(value = "Encontrar jogadores que estejam procurando por vagas em times")
    @GetMapping("/playersOpenToWork")
    @PreAuthorize("hasAnyRole('TEAM')")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayersOpenToWorkProjection> findAllPlayersOpenToWork(@RequestParam(required = false) Long yearsOfExperience) {
        return playerService.findAllPlayersOpenToWork(yearsOfExperience);
    }

    @ApiOperation(value = "Convidar jogador para se juntar ao time")
    @PostMapping("/invitePlayer")
    @ResponseStatus(HttpStatus.OK)
    public void invitePlayerToJoinTheTeam(@PathVariable Long playerId) {
        teamService.inviteTeamToJoinTheTeam(playerId);
    }

}
