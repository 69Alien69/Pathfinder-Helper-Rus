package ru.hackass122.pathfinderhelper.game_data.mapper;

import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.spellcasting.Spell;

public interface SpellDtoMapper {
    SpellResponseDto entityToResponseDto(Spell spell);
}
