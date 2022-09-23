package com.stonks.gamestonks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamRequestSearchDto {
    private LocalDate vacancyStartDate;
    private Long yearsOfExperience;
    private String game;
}
