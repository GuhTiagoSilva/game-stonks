package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel, Long> {
}
