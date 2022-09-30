package com.stonks.gamestonks.services;

import com.stonks.gamestonks.dto.TrainingRoomDto;
import com.stonks.gamestonks.models.GameModel;
import com.stonks.gamestonks.models.PlayerModel;
import com.stonks.gamestonks.models.TrainingModel;
import com.stonks.gamestonks.models.TrainingRoomModel;
import com.stonks.gamestonks.repositories.GameRepository;
import com.stonks.gamestonks.repositories.TrainingRepository;
import com.stonks.gamestonks.repositories.TrainingRoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class TrainingRoomService {

    private final TrainingRoomRepository trainingRoomRepository;
    private final GameRepository gameRepository;
    private final TrainingRepository trainingRepository;

    private final AuthService authService;

    public TrainingRoomService(TrainingRoomRepository trainingRoomRepository,
                               GameRepository gameRepository,
                               TrainingRepository trainingRepository,
                               AuthService authService
    ) {
        this.trainingRoomRepository = trainingRoomRepository;
        this.gameRepository = gameRepository;
        this.trainingRepository = trainingRepository;
        this.authService = authService;
    }

    @Transactional
    public void createTrainingRoom(TrainingRoomDto trainingRoomDto) {

        PlayerModel authUser = authService.authenticated();

        TrainingRoomModel trainingRoomModel = new TrainingRoomModel();
        trainingRoomModel.setDescription(trainingRoomDto.getDescription());
        trainingRoomModel.setName(trainingRoomDto.getName());
        trainingRoomModel.setAvailable(true);
        trainingRoomModel.setUserModel(authUser);

        trainingRoomModel = trainingRoomRepository.save(trainingRoomModel);

        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setTrainingRoomModel(trainingRoomModel);
        trainingModel.setDescription(trainingRoomModel.getDescription());
        trainingModel.setTitle(trainingRoomModel.getName());
        trainingModel.setStartDate(trainingRoomDto.getStartDate());
        trainingModel.setEndDate(trainingRoomDto.getEndDate());
        trainingModel.setWeekDays(trainingRoomDto.getWeekDays());

        Set<GameModel> games = new HashSet<>();

        GameModel gameModel = new GameModel();
        gameModel.setName(trainingRoomDto.getGame());
        gameRepository.save(gameModel);

        games.add(gameModel);

        trainingModel.setGames(games);
        trainingRepository.save(trainingModel);

    }


}
