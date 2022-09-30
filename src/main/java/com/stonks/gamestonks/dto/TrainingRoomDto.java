package com.stonks.gamestonks.dto;

import com.stonks.gamestonks.enums.WeekDays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingRoomDto {
    private Long id;
    private String name;
    private String description;
    private String game;
    private List<WeekDays> weekDays = new ArrayList<>();
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
