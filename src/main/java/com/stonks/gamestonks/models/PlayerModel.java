package com.stonks.gamestonks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_PLAYERS")
public class PlayerModel extends UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private long yearsOfExperience;
    private int level;
    @ManyToMany
    @JoinTable(
            name = "TB_PLAYER_GAMES",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<GameModel> games = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private VacancyModel vacancy;
    public PlayerModel(Long playerId) {
        this.setId(playerId);
    }

}
