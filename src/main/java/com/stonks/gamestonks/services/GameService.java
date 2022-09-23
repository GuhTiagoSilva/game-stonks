package com.stonks.gamestonks.services;

import com.stonks.gamestonks.dto.GameDto;
import com.stonks.gamestonks.models.GameModel;
import com.stonks.gamestonks.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional
    public void createGame(GameDto gameDto) {
        GameModel model = new GameModel();
        model.setName(gameDto.getName());
        gameRepository.save(model);
    }

}
