package ru.hackass122.pathfinderhelper.game_data.service;

import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellCastingEntryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.spellcasting.SpellCastingEntry;

import java.util.Set;

public interface SpellCastingEntryService {
    Set<SpellCastingEntry> getSpellCastingEntriesByIds(Set<Long> spellCastingEntryIds);
    Set<SpellCastingEntryResponseDto>getAllSpellCastingEntriesResponseDtos();
}
