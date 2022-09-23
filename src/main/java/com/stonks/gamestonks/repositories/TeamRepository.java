package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.TeamModel;
import com.stonks.gamestonks.repositories.projections.TeamGameProjection;
import com.stonks.gamestonks.repositories.projections.TeamProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TeamRepository extends JpaRepository<TeamModel, Long> {

    @Query(value =
            "select\n" +
                    "tt.name as teamName,\n" +
                    "tv.name as vacancyName,\n" +
                    "tv.description as vacancyDescription,\n" +
                    "tv.start_date as vacancyStartDate,\n" +
                    "tv.end_date as vacancyEndDate,\n" +
                    "tt.years_of_experience,\n" +
                    "tg.name as games\n" +
                    "from tb_teams tt\n" +
                    "inner join tb_vacancies tv\n" +
                    "on tv.id = tt.vacancy_id\n" +
                    "inner join tb_teams_games ttg\n" +
                    "on ttg.team_id = tt.id\n" +
                    "inner join tb_games tg\n" +
                    "on tg.id = ttg.game_id\n" +
                    "where tv.vacancy_type = 'TEAM' and (\n" +
                    "(:gameName is null or tg.name like concat('%',:gameName, '%')) and\n" +
                    "(:yearsOfExperience is null or tt.years_of_experience >= :yearsOfExperience) and\n" +
                    "(:startDate is null or tv.start_date >= :startDate)\n" +
                    ")\n",
            nativeQuery = true)
    List<TeamProjection> findOpenVacanciesForTeams(@Param("gameName") String gameName,
                                                   @Param("startDate") LocalDate startDate,
                                                   @Param("yearsOfExperience") Long yearsOfExperience);


    @Query(value = "select\n" +
            "tt.name as teamName,\n" +
            "tt.years_of_experience as yearsOfExperience,\n" +
            "tg.name as games\n" +
            "from tb_teams tt\n" +
            "inner join tb_teams_games ttg\n" +
            "on ttg.team_id = tt.id\n" +
            "inner join tb_games tg\n" +
            "on tg.id = ttg.game_id\n" +
            "where ((:gameName is null or tg.name like :gameName) and (:yearsOfExperience is null or tt.years_of_experience >= :yearsOfExperience))\n", nativeQuery = true)
    List<TeamGameProjection> findAllTeams(@Param("gameName") String gameName,
                                          @Param("yearsOfExperience") Long yearsOfExperience);

}
