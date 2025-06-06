package ru.hackass122.pathfinderhelper.game_data.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hackass122.pathfinderhelper.game_data.entity.SpecialAbility;

import java.util.Optional;
import java.util.Set;

public interface SpecialAbilityRepository extends JpaRepository<SpecialAbility, Long> {
    Optional<Set<SpecialAbility>> findByCodeIn(Set<String> codes);
    Optional<SpecialAbility> findSpecialAbilityByCode(String code);
}
