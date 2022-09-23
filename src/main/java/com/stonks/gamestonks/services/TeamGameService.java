package com.stonks.gamestonks.services;

import com.stonks.gamestonks.models.GameModel;
import com.stonks.gamestonks.models.TeamModel;
import com.stonks.gamestonks.repositories.GameRepository;
import com.stonks.gamestonks.repositories.TeamRepository;
import com.stonks.gamestonks.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamGameService {

    private final GameRepository gameRepository;
    private final TeamRepository teamRepository;

    public TeamGameService(TeamRepository teamRepository, GameRepository gameRepository) {
        this.teamRepository = teamRepository;
        this.gameRepository = gameRepository;
    }

    @Transactional
    public void createTeamGame(Long gameId, Long teamId) {

        TeamModel teamModel = teamRepository.findById(teamId).orElseThrow(() -> new ResourceNotFoundException("Team not found: " + teamId));
        GameModel gameModel = gameRepository.findById(gameId).orElseThrow(() -> new ResourceNotFoundException("Team not found: " + teamId));



    }

}
