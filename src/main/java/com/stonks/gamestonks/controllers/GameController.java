package com.stonks.gamestonks.controllers;

import com.stonks.gamestonks.dto.GameDto;
import com.stonks.gamestonks.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createGame(@RequestBody GameDto gameDto) {
        gameService.createGame(gameDto);
    }

}
