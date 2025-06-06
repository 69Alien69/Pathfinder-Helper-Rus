package ru.hackass122.pathfinderhelper.game_data.repository.entity;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;

import java.util.Set;


public interface EffectRepository extends JpaRepository<Effect, Long> {
    Set<Effect> findAllByCodeIn(Set<String> codes);
}
