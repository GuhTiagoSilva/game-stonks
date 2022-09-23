package com.stonks.gamestonks.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Instant timestamp;

    private Integer status;

    private String error;

    private String message;

    private String path;
}
