package com.stonks.gamestonks.dto;

import com.stonks.gamestonks.models.RoleModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    private Long id;
    private String authority;

    public RoleDto(RoleModel role) {
        this.id = role.getId();
        this.authority = role.getAuthority();
    }
}
