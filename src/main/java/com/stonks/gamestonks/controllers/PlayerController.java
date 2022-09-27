package com.stonks.gamestonks.controllers;

import com.stonks.gamestonks.dto.PlayerDto;
import com.stonks.gamestonks.services.PlayerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void createPlayer(@RequestBody PlayerDto playerDto) {
        playerService.createPlayer(playerDto);
    }

    @ApiOperation(value = "Encontrar jogador por ID")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDto findById(@PathVariable Long id) {
        return playerService.findById(id);
    }

}
