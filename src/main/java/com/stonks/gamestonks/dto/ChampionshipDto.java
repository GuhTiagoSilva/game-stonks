package com.stonks.gamestonks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChampionshipDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
}
