package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.TrainingRoomModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRoomRepository extends JpaRepository<TrainingRoomModel, Long> {
}
