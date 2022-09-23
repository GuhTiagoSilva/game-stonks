package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.PlayerModel;
import com.stonks.gamestonks.models.VacancyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {
}
