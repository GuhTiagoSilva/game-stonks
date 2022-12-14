package com.stonks.gamestonks.dto;

import com.stonks.gamestonks.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String cpf;
    private RoleDto roleDto;

    public UserDto(UserModel user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.cpf = user.getCpf();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.lastName = user.getLastName();
        this.roleDto = new RoleDto(user.getRole());
    }
}
