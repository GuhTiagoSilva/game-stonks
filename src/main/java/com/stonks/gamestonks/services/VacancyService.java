package com.stonks.gamestonks.services;

import com.stonks.gamestonks.dto.VacancyDto;
import com.stonks.gamestonks.models.PlayerModel;
import com.stonks.gamestonks.models.VacancyModel;
import com.stonks.gamestonks.repositories.VacancyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    private final AuthService authService;

    public VacancyService(VacancyRepository vacancyRepository, AuthService authService) {
        this.vacancyRepository = vacancyRepository;
        this.authService = authService;
    }

    @Transactional
    public void createVacancy(VacancyDto vacancyDto) {

        PlayerModel playerModel = authService.authenticated();
        VacancyModel model = new VacancyModel();
        model.setDescription(vacancyDto.getDescription());
        model.setEndDate(vacancyDto.getEndDate());
        model.setVacancyType(vacancyDto.getVacancyType());
        model.setAuthor(playerModel);
        vacancyRepository.save(model);
    }

}
