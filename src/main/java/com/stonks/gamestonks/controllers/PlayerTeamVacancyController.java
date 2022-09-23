package com.stonks.gamestonks.controllers;

import com.stonks.gamestonks.dto.PlayerTeamVacancyDto;
import com.stonks.gamestonks.services.PlayerTeamVacancyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerTeamVacancyController {

    private final PlayerTeamVacancyService playerTeamVacancyService;

    public PlayerTeamVacancyController(PlayerTeamVacancyService playerTeamVacancyService) {
        this.playerTeamVacancyService = playerTeamVacancyService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{playerId}/vacancies/{vacancyId}/teams/{teamId}")
    public void applyToVacancy(@RequestBody PlayerTeamVacancyDto playerTeamVacancyDto,
                               @PathVariable(value = "playerId") Long playerId,
                               @PathVariable(value = "vacancyId") Long vacancyId,
                               @PathVariable(value = "teamId") Long teamId
    ) {
        playerTeamVacancyService.applyToVacancy(playerTeamVacancyDto, playerId, vacancyId, teamId);
    }

}
