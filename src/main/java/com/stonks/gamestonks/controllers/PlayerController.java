package com.stonks.gamestonks.controllers;

import com.stonks.gamestonks.dto.PlayerDto;
import com.stonks.gamestonks.services.PlayerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
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
    @PreAuthorize("hasAnyRole('TEAM', 'PLAYER')")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPlayer(@Validated @RequestBody PlayerDto playerDto) {
        playerService.createPlayer(playerDto);
    }

    @ApiOperation(value = "Encontrar jogador por ID")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('TEAM', 'PLAYER')")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDto findById(@PathVariable Long id) {
        return playerService.findById(id);
    }

    @ApiOperation(value = "Atualizar usuario autenticado")
    @PutMapping("/update")
    @PreAuthorize("hasAnyRole('PLAYER')")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDto update(@Validated @RequestBody PlayerDto playerDto) {
        return playerService.update(playerDto);
    }

}
