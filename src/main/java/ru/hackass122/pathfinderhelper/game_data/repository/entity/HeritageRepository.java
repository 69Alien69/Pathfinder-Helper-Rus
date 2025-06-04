package ru.hackass122.pathfinderhelper.game_data.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hackass122.pathfinderhelper.game_data.entity.Heritage;

import java.util.Optional;
import java.util.Set;

public interface HeritageRepository extends JpaRepository<Heritage, Long> {
    Optional<Set<Heritage>> findHeritageByCodeIn(Set<String> codes);
}
