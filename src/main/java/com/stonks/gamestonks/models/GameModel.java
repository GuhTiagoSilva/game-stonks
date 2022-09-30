package com.stonks.gamestonks.models;

import com.stonks.gamestonks.dto.GameDto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_GAMES")
public class GameModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "games")
    @Setter(AccessLevel.NONE)
    private Set<PlayerModel> players = new HashSet<>();
    @ManyToMany(mappedBy = "games")
    @Setter(AccessLevel.NONE)
    private Set<TeamModel> teams = new HashSet<>();
    @ManyToMany(mappedBy = "games")
    private Set<TrainingModel> trainings = new HashSet<>();

    public GameModel(GameDto gameDto) {
        this.id = gameDto.getId();
        this.name = gameDto.getName();
    }
}
