package com.stonks.gamestonks.repositories;

import com.stonks.gamestonks.models.TrainingRoomModel;
import com.stonks.gamestonks.repositories.projections.TrainingRoomProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TrainingRoomRepository extends JpaRepository<TrainingRoomModel, Long> {

    @Query(value = "select\n" +
            "ttr.id as id, " +
            "ttr.name as trainingRoomName,\n" +
            "ttr.description as trainingRoomDescription,\n" +
            "concat (tu.first_name , ' ', tu.last_name) as responsible,\n" +
            "tg.name as game,\n" +
            "tt.start_date as startDate,\n" +
            "tt.end_date as endDate\n" +
            "from tb_training_room ttr\n" +
            "inner join tb_users tu\n" +
            "on tu.id = ttr.user_id\n" +
            "inner join tb_training_games ttg\n" +
            "on ttg.training_id = ttr.id\n" +
            "inner join tb_games tg\n" +
            "on tg.id = ttg.game_id\n" +
            "inner join tb_training tt\n" +
            "on tt.id = ttr.id\n" +
            "inner join tb_week_days twd\n" +
            "on twd.training_id = tt.id\n" +
            "where ttr.is_available = true\n", nativeQuery = true)
    List<TrainingRoomProjection> findTrainingRoom();

    @Query(value = "select\n" +
            "ttr.name as trainingRoomName,\n" +
            "ttr.description as trainingRoomDescription,\n" +
            "concat (tu.first_name , ' ', tu.last_name) as responsible,\n" +
            "tg.name as game,\n" +
            "tt.start_date as startDate,\n" +
            "tt.end_date as endDate\n" +
            "from tb_training_room ttr\n" +
            "inner join tb_users tu\n" +
            "on tu.id = ttr.user_id\n" +
            "inner join tb_training_games ttg\n" +
            "on ttg.training_id = ttr.id\n" +
            "inner join tb_games tg\n" +
            "on tg.id = ttg.game_id\n" +
            "inner join tb_training tt\n" +
            "on tt.id = ttr.id\n" +
            "inner join tb_week_days twd\n" +
            "on twd.training_id = tt.id\n" +
            "where ttr.is_available = true and ttr.id = :id limit 1\n", nativeQuery = true)
    Optional<TrainingRoomProjection> findTrainingRoomById(@Param("id") Long id);

}
