package com.stonks.gamestonks.services;

import com.stonks.gamestonks.dto.PlayerTeamVacancyDto;
import com.stonks.gamestonks.enums.VacancyStatus;
import com.stonks.gamestonks.models.PlayerModel;
import com.stonks.gamestonks.models.PlayerTeamVacancyModel;
import com.stonks.gamestonks.models.TeamModel;
import com.stonks.gamestonks.models.VacancyModel;
import com.stonks.gamestonks.pk.PlayerTeamPK;
import com.stonks.gamestonks.repositories.PlayerRepository;
import com.stonks.gamestonks.repositories.PlayerTeamVacancyRepository;
import com.stonks.gamestonks.repositories.TeamRepository;
import com.stonks.gamestonks.repositories.VacancyRepository;
import com.stonks.gamestonks.services.exceptions.BusinessException;
import com.stonks.gamestonks.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerTeamVacancyService {

    private final PlayerTeamVacancyRepository playerTeamVacancyRepository;

    private final TeamRepository teamRepository;

    private final PlayerRepository playerRepository;

    private final VacancyRepository vacancyRepository;

    public PlayerTeamVacancyService(PlayerTeamVacancyRepository playerTeamVacancyRepository,
                                    TeamRepository teamRepository,
                                    PlayerRepository playerRepository,
                                    VacancyRepository vacancyRepository
    ) {
        this.playerTeamVacancyRepository = playerTeamVacancyRepository;
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.vacancyRepository = vacancyRepository;
    }

    @Transactional
    public void applyToVacancy(PlayerTeamVacancyDto playerTeamVacancyDto, Long playerId, Long vacancyId, Long teamId) {

        VacancyModel vacancyModel = vacancyRepository.findById(vacancyId).orElseThrow(() -> new ResourceNotFoundException("Vacancy Not Found"));
        PlayerModel playerModel = playerRepository.findById(playerId).orElseThrow(() -> new ResourceNotFoundException("Player Not Found"));
        TeamModel teamModel = teamRepository.findById(teamId).orElseThrow(() -> new ResourceNotFoundException("Team Not Found"));

        PlayerTeamPK playerTeamPK = new PlayerTeamPK();
        playerTeamPK.setPlayer(playerModel);
        playerTeamPK.setVacancyModel(vacancyModel);
        playerTeamPK.setTeam(teamModel);

        if (playerTeamVacancyRepository.existsById(playerTeamPK))
            throw new BusinessException("This player is already in this vacancy.");

        vacancyModel.setVacancyStatus(VacancyStatus.PENDING);

        // Enviar e-mail para o user da vaga

        PlayerTeamVacancyModel playerTeamVacancyModel = new PlayerTeamVacancyModel();
        playerTeamVacancyModel.setContractType(playerTeamVacancyDto.getContractType());
        playerTeamVacancyModel.setPrimaryKey(playerTeamPK);

        playerTeamVacancyRepository.save(playerTeamVacancyModel);
    }

}
