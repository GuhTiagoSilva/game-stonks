package com.stonks.gamestonks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rank implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Long id;
    private String title;
    private Integer position;
}
