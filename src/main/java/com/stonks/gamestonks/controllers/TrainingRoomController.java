package com.stonks.gamestonks.controllers;


import com.stonks.gamestonks.dto.TrainingRoomDto;
import com.stonks.gamestonks.services.TrainingRoomService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void createTrainingRoom(@RequestBody TrainingRoomDto trainingRoomDto) {
        trainingRoomService.createTrainingRoom(trainingRoomDto);
    }

}
