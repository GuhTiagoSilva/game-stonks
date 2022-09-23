package com.stonks.gamestonks.dto;

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
public class TeamDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private Long vacancyId;

    public TeamDto(TeamModel teamModel) {
        id = teamModel.getId();
        name = teamModel.getName();
        description = teamModel.getDescription();
        vacancyId = teamModel.getVacancy().getId();
    }

}
