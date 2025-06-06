package ru.hackass122.pathfinderhelper.game_data.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hackass122.pathfinderhelper.game_data.entity.Feat;

import java.util.Optional;
import java.util.Set;

public interface FeatRepository extends JpaRepository<Feat, Long> {
    Optional<Set<Feat>> findFeatByCodeIn(Set<String> codes);
    Optional<Feat> findFeatByCode(String code);
}
