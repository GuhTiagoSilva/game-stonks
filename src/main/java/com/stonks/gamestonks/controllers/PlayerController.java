package com.stonks.gamestonks.controllers;

import com.stonks.gamestonks.models.Player;
import com.stonks.gamestonks.services.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/players")
@AllArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/{id}")
    public Player findById(@PathVariable Long id) {
        return playerService.findById(id);
    }

}
