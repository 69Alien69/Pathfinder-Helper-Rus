package ru.hackass122.pathfinderhelper.game_data.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hackass122.pathfinderhelper.game_data.entity.spellcasting.SpellCastingEntry;

public interface SpellCastingEntryRepository extends JpaRepository<SpellCastingEntry, Long> {
}
