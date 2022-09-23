package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.ChampionshipTeamVacancyModel;
import com.stonks.gamestonks.pk.ChampionshipTeamVacancyPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionshipTeamVacancyRepository extends JpaRepository<ChampionshipTeamVacancyModel, ChampionshipTeamVacancyPK> {
}
