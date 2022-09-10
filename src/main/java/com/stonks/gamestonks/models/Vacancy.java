package com.stonks.gamestonks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_vacancy")
public class Vacancy implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Instant startDate;
    private Instant endDate;
    @OneToMany(mappedBy = "vacancy")
    private List<Player> players = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team teams;
}
