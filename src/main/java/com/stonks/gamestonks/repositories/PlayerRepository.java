package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.Player;
import com.stonks.gamestonks.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
