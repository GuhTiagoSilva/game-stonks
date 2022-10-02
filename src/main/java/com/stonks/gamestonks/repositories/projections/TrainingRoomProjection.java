package com.stonks.gamestonks.repositories.projections;

import java.time.LocalDateTime;

public interface TrainingRoomProjection {

    Long getId();
    String getTrainingRoomName();
    String getTrainingRoomDescription();
    String getResponsible();
    Long getGameId();
    String getGame();
    LocalDateTime getStartDate();
    LocalDateTime getEndDate();

}
