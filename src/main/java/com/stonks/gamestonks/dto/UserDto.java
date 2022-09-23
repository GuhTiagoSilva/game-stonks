package com.stonks.gamestonks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String cpf;
}
