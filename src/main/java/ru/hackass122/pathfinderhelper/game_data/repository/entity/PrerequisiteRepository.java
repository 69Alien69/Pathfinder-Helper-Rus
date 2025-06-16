package ru.hackass122.pathfinderhelper.game_data.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hackass122.pathfinderhelper.game_data.entity.prerequisite.Prerequisite;

import java.util.Optional;
import java.util.Set;

public interface PrerequisiteRepository extends JpaRepository<Prerequisite, Long> {
    Set<Prerequisite> findAllByCodeIn(Set<String> codes);
    Optional<Prerequisite> findPrerequisiteByCode();
}
