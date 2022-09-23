package com.stonks.gamestonks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
}
