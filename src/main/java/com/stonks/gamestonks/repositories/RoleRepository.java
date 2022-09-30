package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
}
