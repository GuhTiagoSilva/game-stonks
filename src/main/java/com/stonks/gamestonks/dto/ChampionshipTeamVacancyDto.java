package com.stonks.gamestonks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChampionshipTeamVacancyDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private long championshipId;
    private long teamId;
    private long vacancyId;
}
