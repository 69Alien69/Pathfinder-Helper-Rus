package ru.hackass122.pathfinderhelper.game_data.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellCastingEntryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellKnownResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellSlotsResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.spellcasting.SpellCastingEntry;
import ru.hackass122.pathfinderhelper.game_data.entity.spellcasting.SpellKnown;
import ru.hackass122.pathfinderhelper.game_data.entity.spellcasting.SpellSlots;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpellCastingEntryDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpellKnownDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpellSlotsDtoMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SpellCastingEntryDtoMapperImpl implements SpellCastingEntryDtoMapper {

    private final SpellSlotsDtoMapper spellSlotsDtoMapper;
    private final SpellKnownDtoMapper spellKnownDtoMapper;

    public SpellCastingEntryDtoMapperImpl(SpellSlotsDtoMapper spellSlotsDtoMapper, SpellKnownDtoMapper spellKnownDtoMapper) {
        this.spellSlotsDtoMapper = spellSlotsDtoMapper;
        this.spellKnownDtoMapper = spellKnownDtoMapper;
    }

    @Override
    public SpellCastingEntryResponseDto entityToResponseDto(SpellCastingEntry spellCastingEntry) {

        List<SpellSlotsResponseDto> slots = new ArrayList<>();
        Set<SpellKnownResponseDto> knownSpells = new HashSet<>();

        for(SpellSlots spellSlots : spellCastingEntry.getSlots()) {
            slots.add(spellSlotsDtoMapper.entityToResponseDto(spellSlots));
        }

        for (SpellKnown knownSpell : spellCastingEntry.getKnownSpells()) {
            knownSpells.add(spellKnownDtoMapper.entityToResponseDto(knownSpell));
        }

        return new SpellCastingEntryResponseDto(spellCastingEntry.getMagicTradition(),
                spellCastingEntry.isHasSpells(),
                slots,
                knownSpells);
    }
}
