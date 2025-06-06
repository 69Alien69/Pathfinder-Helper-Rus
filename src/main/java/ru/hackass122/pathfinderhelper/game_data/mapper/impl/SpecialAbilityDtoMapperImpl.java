package ru.hackass122.pathfinderhelper.game_data.mapper.impl;


import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.dto.request.SpecialAbilityCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.EffectResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.SpecialAbility;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;
import ru.hackass122.pathfinderhelper.game_data.mapper.EffectDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpecialAbilityDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.service.EffectService;


@Component
public class SpecialAbilityDtoMapperImpl implements SpecialAbilityDtoMapper {

    private final EffectDtoMapper effectDtoMapper;

    private final EffectService effectService;

    public SpecialAbilityDtoMapperImpl(EffectDtoMapper effectDtoMapper, EffectService effectService) {
        this.effectDtoMapper = effectDtoMapper;
        this.effectService = effectService;
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

    @Override
    public SpecialAbility creationRequestDtoToEntity(SpecialAbilityCreationRequestDto specialAbilityCreationRequestDto) {
        Effect effect = effectService.getEffectByCode(specialAbilityCreationRequestDto.effectCode());
        return new SpecialAbility(null, specialAbilityCreationRequestDto.name(),
                specialAbilityCreationRequestDto.description(),
                specialAbilityCreationRequestDto.legacy(),
                null,
                effect);
    }
}
