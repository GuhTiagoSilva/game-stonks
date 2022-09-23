package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.ChampionshipModel;
import com.stonks.gamestonks.models.VacancyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionshipRepository extends JpaRepository<ChampionshipModel, Long> {
}
