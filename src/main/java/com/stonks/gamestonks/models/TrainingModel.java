package com.stonks.gamestonks.models;

import com.stonks.gamestonks.enums.WeekDays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_TRAINING")
public class TrainingModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ElementCollection(targetClass = WeekDays.class)
    @JoinTable(name = "tb_week_days", joinColumns = @JoinColumn(name = "training_id"))
    @Enumerated(EnumType.STRING)
    private List<WeekDays> weekDays = new ArrayList<>();
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "training_room_id")
    private TrainingRoomModel trainingRoomModel;
    @ManyToMany
    @JoinTable(name = "tb_training_games", joinColumns = @JoinColumn(name = "training_id"), inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<GameModel> games = new HashSet<>();
}
