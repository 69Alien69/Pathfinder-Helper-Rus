package ru.hackass122.pathfinderhelper.game_data.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hackass122.pathfinderhelper.game_data.entity.GameClass;

public interface GameClassRepository extends JpaRepository<GameClass, Long> {
    GameClass findGameClassByCode(String code);

}
