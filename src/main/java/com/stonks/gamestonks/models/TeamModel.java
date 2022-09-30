package com.stonks.gamestonks.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_TEAMS")
public class TeamModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long yearsOfExperience;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToMany
    @JoinTable(
            name = "TB_TEAMS_GAMES",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    @Setter(AccessLevel.NONE)
    private Set<GameModel> games = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private VacancyModel vacancy;
    @ManyToMany(mappedBy = "teams")
    private Set<TrainingRoomModel> trainingRoomModels = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "author_id")
    private PlayerModel author;
}
