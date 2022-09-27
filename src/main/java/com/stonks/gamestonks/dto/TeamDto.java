package com.stonks.gamestonks.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.stonks.gamestonks.models.TeamModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private Long vacancyId;

    private VacancyDto vacancyDto;

    public TeamDto(TeamModel teamModel, VacancyDto dto) {
        id = teamModel.getId();
        name = teamModel.getName();
        description = teamModel.getDescription();
        vacancyDto = dto;
    }

}
