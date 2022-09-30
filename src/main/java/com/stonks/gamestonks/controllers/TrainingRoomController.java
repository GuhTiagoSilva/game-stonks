package com.stonks.gamestonks.controllers;


import com.stonks.gamestonks.dto.TrainingRoomDto;
import com.stonks.gamestonks.repositories.projections.TrainingRoomProjection;
import com.stonks.gamestonks.services.TrainingRoomService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training-rooms")
public class TrainingRoomController {

    private final TrainingRoomService trainingRoomService;

    public TrainingRoomController(TrainingRoomService trainingRoomService) {
        this.trainingRoomService = trainingRoomService;
    }

    @ApiOperation("Criar sala de treinamento")
    @PreAuthorize("hasAnyRole('TEAM', 'PLAYER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTrainingRoom(@RequestBody TrainingRoomDto trainingRoomDto) {
        trainingRoomService.createTrainingRoom(trainingRoomDto);
    }

    @ApiOperation("Obter todas as salas de treinamento disponiveis")
    @PreAuthorize("hasAnyRole('TEAM', 'PLAYER')")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TrainingRoomProjection> findAllTrainingRoom() {
        return trainingRoomService.findAllTrainingRoom();
    }

}
