package com.stonks.gamestonks.models;

import com.stonks.gamestonks.enums.VacancyStatus;
import com.stonks.gamestonks.enums.VacancyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_VACANCIES")
public class VacancyModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VacancyType vacancyType;
    @Enumerated(EnumType.STRING)
    private VacancyStatus vacancyStatus;
    private LocalDate startDate;
    private LocalDate endDate;

    public VacancyModel(Long vacancyId) {
        id = vacancyId;
    }

}
