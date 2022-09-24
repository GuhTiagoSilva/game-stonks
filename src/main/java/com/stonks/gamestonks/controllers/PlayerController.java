package com.stonks.gamestonks.controllers;

import com.stonks.gamestonks.dto.PlayerDto;
import com.stonks.gamestonks.services.PlayerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
@CrossOrigin(origins = "*")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @ApiOperation(value = "Criar jogador")
    @PostMapping
    public void createPlayer(@RequestBody PlayerDto playerDto) {
        playerService.createPlayer(playerDto);
    }

}
