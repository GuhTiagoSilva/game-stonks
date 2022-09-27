package com.stonks.gamestonks.controllers;

import com.stonks.gamestonks.dto.GameDto;
import com.stonks.gamestonks.services.GameService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
@CrossOrigin(origins = "*")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @ApiOperation(value = "Criar um jogo")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('TEAM', 'PLAYER')")
    @PostMapping
    public void createGame(@RequestBody GameDto gameDto) {
        gameService.createGame(gameDto);
    }

}
