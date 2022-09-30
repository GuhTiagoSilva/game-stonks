package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.TrainingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<TrainingModel, Long> {
}
