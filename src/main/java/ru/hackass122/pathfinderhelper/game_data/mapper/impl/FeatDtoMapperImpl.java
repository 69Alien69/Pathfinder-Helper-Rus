package ru.hackass122.pathfinderhelper.game_data.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.dto.response.EffectResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.FeatResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Feat;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;
import ru.hackass122.pathfinderhelper.game_data.mapper.EffectDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.FeatDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.TraitDtoMapper;

import java.util.HashSet;
import java.util.Set;

@Component
public class FeatDtoMapperImpl implements FeatDtoMapper {

    private final TraitDtoMapper traitDtoMapper;
    private final EffectDtoMapper effectDtoMapper;

    public FeatDtoMapperImpl(TraitDtoMapper traitDtoMapper, EffectDtoMapper effectDtoMapper) {
        this.traitDtoMapper = traitDtoMapper;
        this.effectDtoMapper = effectDtoMapper;
    }

    @Override
    public FeatResponseDto entityToResponseDto(Feat feat) {

        Set<TraitResponseDto> traitResponseDtos = new HashSet<>();
        Set<EffectResponseDto> effectResponseDtos = new HashSet<>();

        for (Trait trait : feat.getTraits()) {
            traitResponseDtos.add(traitDtoMapper.entityToResponseDto(trait));
        }

        for (Effect effect : feat.getEffects()) {
            effectResponseDtos.add(effectDtoMapper.entityToResponseDto(effect));
        }

        return new FeatResponseDto(traitResponseDtos,
                feat.getCode(),
                feat.getName(),
                feat.getDescription(),
                feat.isLegacy(),
                feat.getLevel(),
                effectResponseDtos,
                feat.getPrerequisites());
    }
}
