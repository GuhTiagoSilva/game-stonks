package com.stonks.gamestonks.services;

import com.stonks.gamestonks.models.PlayerModel;
import com.stonks.gamestonks.models.UserModel;
import com.stonks.gamestonks.repositories.PlayerRepository;
import com.stonks.gamestonks.services.exceptions.UnauthorizedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final PlayerRepository repository;

    public AuthService(PlayerRepository playerRepository) {
        this.repository = playerRepository;
    }

    @Transactional(readOnly = true)
    public PlayerModel authenticated() {
        try {

            String username = SecurityContextHolder.getContext().getAuthentication().getName(); // get the current username logged
            return repository.findByEmail(username);

        } catch (Exception e) {
            throw new UnauthorizedException("Invalid User");
        }
    }
}
