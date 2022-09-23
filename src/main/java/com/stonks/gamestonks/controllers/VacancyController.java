package com.stonks.gamestonks.controllers;

import com.stonks.gamestonks.dto.VacancyDto;
import com.stonks.gamestonks.services.VacancyService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vacancies")
public class VacancyController {

    private final VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createVacancy(@RequestBody VacancyDto vacancyDto) {
        vacancyService.createVacancy(vacancyDto);
    }
}
