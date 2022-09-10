package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.Team;
import com.stonks.gamestonks.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
