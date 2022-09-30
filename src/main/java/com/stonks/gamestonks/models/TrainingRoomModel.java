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
@Table(name = "TB_TRAINING_ROOM")
public class TrainingRoomModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private boolean isAvailable;
    @ManyToMany
    @JoinTable(
            name = "TB_TRAINING_TEAMS",
            joinColumns = @JoinColumn(name = "training_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private Set<TeamModel> teams = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "user_id")
    private PlayerModel userModel;
}
