package com.stonks.gamestonks.repositories.projections;

public interface TeamGameProjection {
    Long getTeamId();
    String getTeamName();
    Long getYearsOfExperience();

    Long getGameId();
    String getGames();
}
