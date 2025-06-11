package ru.hackass122.pathfinderhelper.game_data.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.common.util.EntityCodeGenerator;
import ru.hackass122.pathfinderhelper.game_data.dto.request.FeatCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.EffectResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.FeatResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.PrerequisiteResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Feat;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;
import ru.hackass122.pathfinderhelper.game_data.entity.prerequisite.Prerequisite;
import ru.hackass122.pathfinderhelper.game_data.mapper.EffectDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.FeatDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.PrerequisiteDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.TraitDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.service.EffectService;
import ru.hackass122.pathfinderhelper.game_data.service.PrerequisiteService;
import ru.hackass122.pathfinderhelper.game_data.service.TraitService;

import java.util.HashSet;
import java.util.Set;

@Component
public class FeatDtoMapperImpl implements FeatDtoMapper {

    private final TraitDtoMapper traitDtoMapper;
    private final EffectDtoMapper effectDtoMapper;
    private final PrerequisiteDtoMapper prerequisiteDtoMapper;

    private final TraitService traitService;
    private final EffectService effectService;
    private final PrerequisiteService prerequisiteService;

    public FeatDtoMapperImpl(TraitDtoMapper traitDtoMapper, EffectDtoMapper effectDtoMapper,
                             PrerequisiteDtoMapper prerequisiteDtoMapper, TraitService traitService,
                             EffectService effectService, PrerequisiteService prerequisiteService) {
        this.traitDtoMapper = traitDtoMapper;
        this.effectDtoMapper = effectDtoMapper;
        this.prerequisiteDtoMapper = prerequisiteDtoMapper;
        this.traitService = traitService;
        this.effectService = effectService;
        this.prerequisiteService = prerequisiteService;
    }

    @Override
    public FeatResponseDto entityToResponseDto(Feat feat) {

        Set<TraitResponseDto> traitResponseDtos = new HashSet<>();
        Set<EffectResponseDto> effectResponseDtos = new HashSet<>();
        Set<PrerequisiteResponseDto> prerequisiteResponseDtos = new HashSet<>();

        for (Trait trait : feat.getTraits()) {
            traitResponseDtos.add(traitDtoMapper.entityToResponseDto(trait));
        }

        for (Effect effect : feat.getEffects()) {
            effectResponseDtos.add(effectDtoMapper.entityToResponseDto(effect));
        }

        for (Prerequisite prerequisite : feat.getPrerequisites()) {
            prerequisiteResponseDtos.add((prerequisiteDtoMapper.entityToResponseDto(prerequisite)));
        }

        return new FeatResponseDto(traitResponseDtos,
                feat.getCode(),
                feat.getName(),
                feat.getDescription(),
                feat.isLegacy(),
                feat.getLevel(),
                effectResponseDtos,
                prerequisiteResponseDtos);
    }

    @Override
    public Feat creationRequestDtoToEntity(FeatCreationRequestDto featCreationRequestDto) {
        Set<Trait> traits = traitService.getTraitByCodes(featCreationRequestDto.traitCodes());
        Set<Effect> effects = effectService.getEffectsByCodes(featCreationRequestDto.effectCodes());
        Set<Prerequisite> prerequisites
                = prerequisiteService.getPrerequisitesByCodes(featCreationRequestDto.prerequisiteCodes());

        return new Feat(traits,
                null,
                featCreationRequestDto.name(),
                featCreationRequestDto.description(),
                featCreationRequestDto.legacy(),
                null,
                featCreationRequestDto.level(),
                effects,
                prerequisites);
    }
}
