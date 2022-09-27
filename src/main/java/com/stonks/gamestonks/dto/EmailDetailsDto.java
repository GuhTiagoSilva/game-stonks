package com.stonks.gamestonks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EmailDetailsDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
