package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.Championship;
import com.stonks.gamestonks.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionshipRepository extends JpaRepository<Championship, Long> {
}
