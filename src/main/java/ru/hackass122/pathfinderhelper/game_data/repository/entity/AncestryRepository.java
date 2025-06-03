package ru.hackass122.pathfinderhelper.game_data.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hackass122.pathfinderhelper.game_data.entity.Ancestry;

import java.util.Optional;

public interface AncestryRepository extends JpaRepository<Ancestry, Long> {

    Optional<Ancestry>getAncestryByCode(String code);
}
