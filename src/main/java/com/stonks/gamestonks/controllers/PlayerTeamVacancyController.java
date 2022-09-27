package com.stonks.gamestonks.controllers;

import com.stonks.gamestonks.services.PlayerTeamVacancyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
@CrossOrigin(origins = "*")
public class PlayerTeamVacancyController {

    private final PlayerTeamVacancyService playerTeamVacancyService;

    public PlayerTeamVacancyController(PlayerTeamVacancyService playerTeamVacancyService) {
        this.playerTeamVacancyService = playerTeamVacancyService;
    }

    @ApiOperation(value = "Aplica para uma vaga e manda um e-mail")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('PLAYER')")
    @GetMapping("/{vacancyId}/teams/{teamId}")
    public void applyToVacancy(@PathVariable(value = "vacancyId") Long vacancyId,
                               @PathVariable(value = "teamId") Long teamId
    ) {
        playerTeamVacancyService.applyToVacancy(vacancyId, teamId);
    }

}
