package com.stonks.gamestonks.services;

import com.stonks.gamestonks.dto.PlayerTeamVacancyDto;
import com.stonks.gamestonks.models.PlayerModel;
import com.stonks.gamestonks.models.PlayerTeamVacancyModel;
import com.stonks.gamestonks.models.TeamModel;
import com.stonks.gamestonks.models.VacancyModel;
import com.stonks.gamestonks.pk.PlayerTeamPK;
import com.stonks.gamestonks.repositories.PlayerTeamVacancyRepository;
import com.stonks.gamestonks.services.exceptions.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerTeamVacancyService {

    private final PlayerTeamVacancyRepository playerTeamVacancyRepository;


    public PlayerTeamVacancyService(PlayerTeamVacancyRepository playerTeamVacancyRepository) {
        this.playerTeamVacancyRepository = playerTeamVacancyRepository;
    }

    @Transactional
    public void applyToVacancy(PlayerTeamVacancyDto playerTeamVacancyDto, Long playerId, Long vacancyId, Long teamId) {

        PlayerTeamPK playerTeamPK = new PlayerTeamPK();
        playerTeamPK.setPlayer(new PlayerModel(playerId));
        playerTeamPK.setVacancyModel(new VacancyModel(vacancyId));
        playerTeamPK.setTeam(new TeamModel(teamId));

        if (playerTeamVacancyRepository.existsById(playerTeamPK))
            throw new BusinessException("This player is already in this vacancy.");

        PlayerTeamVacancyModel playerTeamVacancyModel = new PlayerTeamVacancyModel();
        playerTeamVacancyModel.setContractType(playerTeamVacancyDto.getContractType());
        playerTeamVacancyModel.setPrimaryKey(playerTeamPK);

        playerTeamVacancyRepository.save(playerTeamVacancyModel);
    }

}
