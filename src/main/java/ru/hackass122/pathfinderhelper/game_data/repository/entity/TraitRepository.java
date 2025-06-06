package ru.hackass122.pathfinderhelper.game_data.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;

import java.util.Optional;
import java.util.Set;

public interface TraitRepository extends JpaRepository<Trait, Long> {
    Optional<Set<Trait>> findTraitByCodeIn(Set<String> codes);
    Optional<Trait> findTraitByCode(String code);
}
