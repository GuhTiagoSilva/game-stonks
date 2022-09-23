package com.stonks.gamestonks.dto;

import com.stonks.gamestonks.enums.ContractType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerTeamVacancyDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private ContractType contractType;
}
