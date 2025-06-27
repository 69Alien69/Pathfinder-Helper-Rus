package ru.hackass122.pathfinderhelper.game_data.mapper;

import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellCastingEntryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.spellcasting.SpellCastingEntry;

public interface SpellCastingEntryDtoMapper {

    SpellCastingEntryResponseDto entityToResponseDto(SpellCastingEntry spellCastingEntry);
}
