package ru.hackass122.pathfinderhelper.game_data.mapper;

import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellKnownResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.spellcasting.SpellKnown;

public interface SpellKnownDtoMapper {
    SpellKnownResponseDto entityToResponseDto(SpellKnown spellKnown);
}
