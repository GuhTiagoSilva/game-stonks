package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.PlayerTeamVacancyModel;
import com.stonks.gamestonks.pk.PlayerTeamPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerTeamVacancyRepository extends JpaRepository<PlayerTeamVacancyModel, PlayerTeamPK> {
}
