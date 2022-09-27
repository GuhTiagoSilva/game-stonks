package com.stonks.gamestonks.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.stonks.gamestonks.enums.VacancyType;
import com.stonks.gamestonks.models.VacancyModel;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    public VacancyDto(VacancyModel entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        startDate = entity.getStartDate();
        endDate = entity.getEndDate();
    }

}
