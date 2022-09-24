package com.stonks.gamestonks.services;

import com.stonks.gamestonks.dto.VacancyDto;
import com.stonks.gamestonks.models.VacancyModel;
import com.stonks.gamestonks.repositories.VacancyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @Transactional
    public void createVacancy(VacancyDto vacancyDto) {
        // Buscar usuario logado e setar na vaga
        VacancyModel model = new VacancyModel();
        model.setDescription(vacancyDto.getDescription());
        model.setEndDate(vacancyDto.getEndDate());
        model.setVacancyType(vacancyDto.getVacancyType());
        vacancyRepository.save(model);
    }

}
