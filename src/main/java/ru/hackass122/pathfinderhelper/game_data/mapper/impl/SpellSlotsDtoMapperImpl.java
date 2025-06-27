package ru.hackass122.pathfinderhelper.game_data.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellSlotsResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.spellcasting.SpellSlots;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpellSlotsDtoMapper;

@Component
public class SpellSlotsDtoMapperImpl implements SpellSlotsDtoMapper {
    @Override
    public SpellSlotsResponseDto entityToResponseDto(SpellSlots spellSlots) {
        return new SpellSlotsResponseDto(spellSlots.getRank(),
                spellSlots.getTotalSlots(),
                spellSlots.getUsedSlots());
    }
}
