package com.stonks.gamestonks.pk;

import com.stonks.gamestonks.models.ChampionshipModel;
import com.stonks.gamestonks.models.TeamModel;
import com.stonks.gamestonks.models.VacancyModel;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ChampionshipTeamVacancyPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private VacancyModel vacancyModel;
    @ManyToOne
    @JoinColumn(name = "championship_id")
    private ChampionshipModel championship;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamModel team;
}
