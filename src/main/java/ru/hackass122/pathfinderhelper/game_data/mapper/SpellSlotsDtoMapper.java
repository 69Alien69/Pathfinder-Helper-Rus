package ru.hackass122.pathfinderhelper.game_data.mapper;

import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellSlotsResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.spellcasting.SpellSlots;

public interface SpellSlotsDtoMapper {
    SpellSlotsResponseDto entityToResponseDto(SpellSlots spellSlots);
}
