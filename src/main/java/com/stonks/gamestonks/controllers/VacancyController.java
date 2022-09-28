package com.stonks.gamestonks.controllers;

import com.stonks.gamestonks.dto.VacancyDto;
import com.stonks.gamestonks.services.VacancyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vacancies")
public class VacancyController {

    private final VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @ApiOperation(value = "Criar uma vaga")
    @PostMapping
    @PreAuthorize("hasAnyRole('TEAM')")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVacancy(@RequestBody VacancyDto vacancyDto) {
        vacancyService.createVacancy(vacancyDto);
    }
}
