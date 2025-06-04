package ru.hackass122.pathfinderhelper.game_data.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;
import ru.hackass122.pathfinderhelper.game_data.mapper.TraitDtoMapper;

@Component
public class TraitDtoMapperImpl implements TraitDtoMapper {
    @Override
    public TraitResponseDto entityToResponseDto(Trait trait) {
        return new TraitResponseDto(trait.getCode(),
                trait.getName(),
                trait.getDescription(),
                trait.isLegacy(),
                trait.getTraitCategory());
    }
}
