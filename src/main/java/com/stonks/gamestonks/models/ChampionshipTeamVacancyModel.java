package com.stonks.gamestonks.models;

import com.stonks.gamestonks.pk.ChampionshipTeamVacancyPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CHAMPIONSHIPS_TEAM_VACANCY")
public class ChampionshipTeamVacancyModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ChampionshipTeamVacancyPK primaryKey = new ChampionshipTeamVacancyPK();
}
