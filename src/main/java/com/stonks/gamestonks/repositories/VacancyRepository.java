package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.VacancyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<VacancyModel, Long> {
}
