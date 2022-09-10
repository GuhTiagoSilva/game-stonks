package com.stonks.gamestonks.controllers;

import com.stonks.gamestonks.services.VacancyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vacancies")
@AllArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;



}
