package ru.hackass122.pathfinderhelper.game_data.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;
import ru.hackass122.pathfinderhelper.game_data.entity.spellcasting.Spell;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpellDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.TraitDtoMapper;

import java.util.HashSet;
import java.util.Set;

@Component
public class SpellDtoMapperImpl implements SpellDtoMapper {

    private final TraitDtoMapper traitDtoMapper;

    public SpellDtoMapperImpl(TraitDtoMapper traitDtoMapper) {
        this.traitDtoMapper = traitDtoMapper;
    }

    @Override
    public SpellResponseDto entityToResponseDto(Spell spell) {

        Set<TraitResponseDto> traits = new HashSet<>();

        for(Trait trait : spell.getTraits()) {
            traits.add(traitDtoMapper.entityToResponseDto(trait));
        }

        return new SpellResponseDto(traits,
                spell.getCode(),
                spell.getName(),
                spell.getDescription(),
                spell.isLegacy(),
                spell.getMagicTradition(),
                spell.isActionCast(),
                spell.getActionCastCost(),
                spell.getTimeCast(),
                spell.getRange(),
                spell.getArea(),
                spell.getTarget(),
                spell.getSaveThrow(),
                spell.getDuration(),
                spell.getEffect());
    }
}
