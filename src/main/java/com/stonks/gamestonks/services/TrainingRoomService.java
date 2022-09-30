package com.stonks.gamestonks.services;

import com.stonks.gamestonks.dto.EmailDetailsDto;
import com.stonks.gamestonks.dto.TrainingRoomDto;
import com.stonks.gamestonks.models.GameModel;
import com.stonks.gamestonks.models.PlayerModel;
import com.stonks.gamestonks.models.TrainingModel;
import com.stonks.gamestonks.models.TrainingRoomModel;
import com.stonks.gamestonks.repositories.GameRepository;
import com.stonks.gamestonks.repositories.TrainingRepository;
import com.stonks.gamestonks.repositories.TrainingRoomRepository;
import com.stonks.gamestonks.repositories.projections.TrainingRoomProjection;
import com.stonks.gamestonks.services.exceptions.ResourceNotFoundException;
import com.stonks.gamestonks.utils.MailMessageUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TrainingRoomService {

    private final TrainingRoomRepository trainingRoomRepository;
    private final GameRepository gameRepository;
    private final TrainingRepository trainingRepository;
    private final AuthService authService;

    private final EmailService emailService;
    private static String htmlBodyMail = MailMessageUtils.getInviteTrainingRoomHtmlMailBody();


    public TrainingRoomService(TrainingRoomRepository trainingRoomRepository,
                               GameRepository gameRepository,
                               TrainingRepository trainingRepository,
                               AuthService authService,
                               EmailService emailService
    ) {
        this.trainingRoomRepository = trainingRoomRepository;
        this.gameRepository = gameRepository;
        this.trainingRepository = trainingRepository;
        this.authService = authService;
        this.emailService = emailService;
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

    @Transactional(readOnly = true)
    public TrainingRoomProjection findById(Long id) {
        TrainingRoomProjection trainingRoomModel = trainingRoomRepository.findTrainingRoomById(id).orElseThrow(() -> new ResourceNotFoundException("Training Room Not Found"));
        return trainingRoomModel;
    }

    @Transactional(readOnly = true)
    public List<TrainingRoomProjection> findAllTrainingRoom() {
        return trainingRoomRepository.findTrainingRoom();
    }

    @Transactional
    public void requestParticipationInTrainingRoom(Long trainingRoomId) {
        PlayerModel playerModel = authService.authenticated();

        TrainingRoomModel trainingRoomModel = trainingRoomRepository.findById(trainingRoomId)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));

        htmlBodyMail = htmlBodyMail.replaceAll("_userEmail_", playerModel.getEmail());
        htmlBodyMail = htmlBodyMail.replaceAll("_username_", trainingRoomModel.getUserModel().getEmail());

        EmailDetailsDto emailDetailsDto = EmailDetailsDto.builder()
                .msgBody(htmlBodyMail)
                .recipient(trainingRoomModel.getUserModel().getEmail())
                .subject("O usuário: " + playerModel.getEmail() + " se interessou pela sala de treinamento: " + trainingRoomModel.getName() + "!!!")
                .build();

        emailService.sendMail(emailDetailsDto);
    }
}
