package com.stonks.gamestonks.services;

import com.stonks.gamestonks.dto.PlayerDto;
import com.stonks.gamestonks.models.PlayerModel;
import com.stonks.gamestonks.repositories.PlayerRepository;
import com.stonks.gamestonks.repositories.UserRepository;
import com.stonks.gamestonks.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    private final UserRepository userRepository;

    public PlayerService(PlayerRepository playerRepository, UserRepository userRepository) {
        this.playerRepository = playerRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void createPlayer(PlayerDto playerDto) {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setYearsOfExperience(playerDto.getYearsOfExperience());
        playerModel.setLevel(playerDto.getLevel());
        playerModel.setEmail(playerDto.getEmail());
        playerModel.setFirstName(playerDto.getFirstName());
        playerModel.setLastName(playerDto.getLastName());
        playerModel.setPassword(playerDto.getPassword());
        playerModel.setCpf(playerDto.getCpf());
        playerRepository.save(playerModel);
    }

    @Transactional(readOnly = true)
    public PlayerDto findById(Long id) {

        PlayerModel playerModel = playerRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found: " + id));

        return new PlayerDto(playerModel);
    }

}
