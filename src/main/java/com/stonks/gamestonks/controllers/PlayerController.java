package com.stonks.gamestonks.controllers;

import com.stonks.gamestonks.dto.PlayerDto;
import com.stonks.gamestonks.services.PlayerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public void createPlayer(@RequestBody PlayerDto playerDto) {
        playerService.createPlayer(playerDto);
    }

}
