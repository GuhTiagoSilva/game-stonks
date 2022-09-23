package com.stonks.gamestonks.dto;

import com.stonks.gamestonks.enums.VacancyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacancyDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private LocalDate appliedDate;
    private Boolean isOpen;
    private LocalDate startDate;
    private LocalDate endDate;
    private VacancyType vacancyType;
}
