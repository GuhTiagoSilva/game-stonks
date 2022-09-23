package com.stonks.gamestonks.models;

import com.stonks.gamestonks.enums.ContractType;
import com.stonks.gamestonks.pk.PlayerTeamPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_PLAYER_TEAM_VACANCY")
public class PlayerTeamVacancyModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PlayerTeamPK primaryKey = new PlayerTeamPK();
    @Enumerated(EnumType.STRING)
    private ContractType contractType;
}
