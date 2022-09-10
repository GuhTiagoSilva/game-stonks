package com.stonks.gamestonks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_player")
public class Player extends User implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String playerSubtitle;
    private String description;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_player_championship",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "championship_id"))
    private List<Championship> championships = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
