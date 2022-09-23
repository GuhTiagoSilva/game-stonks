package com.stonks.gamestonks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto extends UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private long yearsOfExperience;
    private int level;
    private List<GameDto> games = new ArrayList<>();
}
