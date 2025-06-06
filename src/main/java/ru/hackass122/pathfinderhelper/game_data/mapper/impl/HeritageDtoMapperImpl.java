package ru.hackass122.pathfinderhelper.game_data.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.dto.request.HeritageCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.FeatResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.HeritageResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.AttributeModifiers;
import ru.hackass122.pathfinderhelper.game_data.entity.Feat;
import ru.hackass122.pathfinderhelper.game_data.entity.Heritage;
import ru.hackass122.pathfinderhelper.game_data.entity.SpecialAbility;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;
import ru.hackass122.pathfinderhelper.game_data.mapper.FeatDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.HeritageDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpecialAbilityDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.TraitDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.service.FeatService;
import ru.hackass122.pathfinderhelper.game_data.service.SpecialAbilityService;
import ru.hackass122.pathfinderhelper.game_data.service.TraitService;

import java.util.HashSet;
import java.util.Set;

@Component
public class HeritageDtoMapperImpl implements HeritageDtoMapper {

    private final TraitDtoMapper traitDtoMapper;
    private final SpecialAbilityDtoMapper specialAbilityDtoMapper;
    private final FeatDtoMapper featDtoMapper;

    private final TraitService traitService;
    private final SpecialAbilityService specialAbilityService;
    private final FeatService featService;

    public HeritageDtoMapperImpl(TraitDtoMapper traitDtoMapper, SpecialAbilityDtoMapper specialAbilityDtoMapper,
                                 FeatDtoMapper featDtoMapper, TraitService traitService,
                                 SpecialAbilityService specialAbilityService, FeatService featService) {
        this.traitDtoMapper = traitDtoMapper;
        this.specialAbilityDtoMapper = specialAbilityDtoMapper;
        this.featDtoMapper = featDtoMapper;
        this.traitService = traitService;
        this.specialAbilityService = specialAbilityService;
        this.featService = featService;
    }

    @Override
    public HeritageResponseDto entityToResponseDto(Heritage heritage) {
        Set<TraitResponseDto> traitResponseDtos = new HashSet<>();
        Set<SpecialAbilityResponseDto> specialAbilityResponseDtos = new HashSet<>();
        Set<FeatResponseDto> featResponseDtos = new HashSet<>();

        for (Trait trait : heritage.getTraits()) {
            traitResponseDtos.add(traitDtoMapper.entityToResponseDto(trait));
        }

        for (SpecialAbility specialAbility : heritage.getSpecialAbilities()) {
            specialAbilityResponseDtos.add(specialAbilityDtoMapper.entityToResponseDto(specialAbility));
        }

        for (Feat feat : heritage.getHeritageFeats()) {
            featResponseDtos.add(featDtoMapper.entityToResponseDto(feat));
        }

        return new HeritageResponseDto(traitResponseDtos,
                heritage.getCode(),
                heritage.getName(),
                heritage.getDescription(),
                heritage.isLegacy(),
                heritage.getHitPointModifier(),
                heritage.getSize(),
                heritage.getAttributeModifiers().getBoosts(),
                heritage.getAttributeModifiers().getFlaws(),
                specialAbilityResponseDtos,
                heritage.getLanguages(),
                heritage.getSkillProficiencies(),
                heritage.getResistances(),
                heritage.getAcBonus(),
                featResponseDtos);
    }

    @Override
    public Heritage creationRequestDtoToEntity(HeritageCreationRequestDto heritageCreationRequestDto) {

        Set<Trait> traits = traitService.getTraitByCodes(heritageCreationRequestDto.traitCodes());
        AttributeModifiers attributeModifiers = new AttributeModifiers(heritageCreationRequestDto.boosts(),
                heritageCreationRequestDto.flaws());
        Set<SpecialAbility> specialAbilities =
                specialAbilityService.getSpecialAbilitiesByCodes(heritageCreationRequestDto.specialAbilityCodes());
        Set<Feat> feats = featService.getFeatsByCodes(heritageCreationRequestDto.heritageFeatCodes());

        return new Heritage(traits,
                null,
                heritageCreationRequestDto.name(),
                heritageCreationRequestDto.description(),
                heritageCreationRequestDto.legacy(),
                null,
                heritageCreationRequestDto.hitPointModifier(),
                heritageCreationRequestDto.size(),
                attributeModifiers,
                specialAbilities,
                heritageCreationRequestDto.languages(),
                heritageCreationRequestDto.skillProficiencies(),
                heritageCreationRequestDto.resistances(),
                heritageCreationRequestDto.acBonus(),
                feats);
    }
}
