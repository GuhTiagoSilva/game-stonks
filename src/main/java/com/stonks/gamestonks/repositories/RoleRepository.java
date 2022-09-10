package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.Role;
import com.stonks.gamestonks.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
