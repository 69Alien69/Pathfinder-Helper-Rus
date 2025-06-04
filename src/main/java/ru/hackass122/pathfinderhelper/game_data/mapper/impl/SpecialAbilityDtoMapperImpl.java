package ru.hackass122.pathfinderhelper.game_data.mapper.impl;


import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.dto.response.EffectResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.SpecialAbility;
import ru.hackass122.pathfinderhelper.game_data.mapper.EffectDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpecialAbilityDtoMapper;

@Component
public class SpecialAbilityDtoMapperImpl implements SpecialAbilityDtoMapper {

    private final EffectDtoMapper effectDtoMapper;

    public SpecialAbilityDtoMapperImpl(EffectDtoMapper effectDtoMapper) {
        this.effectDtoMapper = effectDtoMapper;
    }


    @Override
    public SpecialAbilityResponseDto entityToResponseDto(SpecialAbility specialAbility) {
        EffectResponseDto effectResponseDto = effectDtoMapper.entityToResponseDto(specialAbility.getEffect());
        return new SpecialAbilityResponseDto(specialAbility.getCode(),
                specialAbility.getName(),
                specialAbility.getDescription(),
                specialAbility.isLegacy(),
                effectResponseDto);
    }
}
