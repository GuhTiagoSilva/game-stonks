package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
}
