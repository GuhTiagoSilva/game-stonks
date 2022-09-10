package com.stonks.gamestonks.services;

import com.stonks.gamestonks.models.Player;
import com.stonks.gamestonks.repositories.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

@Service
@AllArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Transactional(readOnly = true)
    public Player findById(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new ResourceAccessException("ID Not Found: " + id));
    }


}
