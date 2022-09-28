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
    private String authority;

    public RoleDto(RoleModel role) {
        this.authority = role.getAuthority();
    }
}
