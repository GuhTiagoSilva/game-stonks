package com.stonks.gamestonks.pk;

import com.stonks.gamestonks.models.PlayerModel;
import com.stonks.gamestonks.models.TeamModel;
import com.stonks.gamestonks.models.VacancyModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PlayerTeamPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private VacancyModel vacancyModel;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerModel player;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamModel team;

}
