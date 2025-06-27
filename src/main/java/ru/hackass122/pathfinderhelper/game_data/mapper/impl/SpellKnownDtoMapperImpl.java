package ru.hackass122.pathfinderhelper.game_data.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellKnownResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.spellcasting.SpellKnown;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpellDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpellKnownDtoMapper;

@Component
public class SpellKnownDtoMapperImpl implements SpellKnownDtoMapper {

    private final SpellDtoMapper spellDtoMapper;

    public SpellKnownDtoMapperImpl(SpellDtoMapper spellDtoMapper) {
        this.spellDtoMapper = spellDtoMapper;
    }

    @Override
    public SpellKnownResponseDto entityToResponseDto(SpellKnown spellKnown) {

        SpellResponseDto spell = spellDtoMapper.entityToResponseDto(spellKnown.getSpell());

        return new SpellKnownResponseDto(spellKnown.getRank(), spell);
    }
}
