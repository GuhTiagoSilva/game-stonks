package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {
    PlayerModel findByEmail(String email);
}
