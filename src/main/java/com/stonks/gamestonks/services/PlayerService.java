package com.stonks.gamestonks.services;

import com.stonks.gamestonks.dto.PlayerDto;
import com.stonks.gamestonks.models.PlayerModel;
import com.stonks.gamestonks.repositories.PlayerRepository;
import com.stonks.gamestonks.repositories.UserRepository;
import com.stonks.gamestonks.services.exceptions.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Log4j2
public class PlayerService implements UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        PlayerModel playerModel = playerRepository.findByEmail(username);

        if (Objects.nonNull(playerModel))
            return playerModel;

        log.error("user not found for e-mail: {}", username);
        throw new UsernameNotFoundException("User Not Found For Email: " + username);
    }
}
