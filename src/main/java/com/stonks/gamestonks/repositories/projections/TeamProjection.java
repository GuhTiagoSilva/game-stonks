package com.stonks.gamestonks.repositories.projections;

import java.time.LocalDate;

public interface TeamProjection {

    String getTeamName();
    String getVacancyName();
    String getVacancyDescription();
    LocalDate getVacancyStartDate();
    LocalDate getVacancyEndDate();
    String getGames();

}
