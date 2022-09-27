package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.PlayerModel;
import com.stonks.gamestonks.repositories.projections.PlayerAppliedVacancyProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<PlayerModel, Long> {
    PlayerModel findByEmail(String email);


    @Query(value = "select\n" +
            "\n" +
            "tu.first_name as firstName,\n" +
            "tu.last_name as lastName,\n" +
            "tu.email as email,\n" +
            "tu.cpf as cpf,\n" +
            "tp.years_of_experience as yearsOfExperience,\n" +
            "tp.level as level\n" +
            "from tb_player_team_vacancy tptv\n" +
            "join tb_players tp on tp.id = tptv.player_id\n" +
            "join tb_users tu on tu.id = tp.id\n" +
            "join tb_vacancies tv on tptv.vacancy_id = tv.id\n" +
            "\n" +
            "where tv.user_id = :authUser ;\n",
            nativeQuery = true)
    List<PlayerAppliedVacancyProjection> findAllAppliedPlayers(@Param("authUser") Long authUser);
}
