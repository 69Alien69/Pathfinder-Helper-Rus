package ru.hackass122.pathfinderhelper.game_data.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.dto.request.AncestryCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.AncestryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.FeatResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.HeritageResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Ancestry;
import ru.hackass122.pathfinderhelper.game_data.entity.AttributeModifiers;
import ru.hackass122.pathfinderhelper.game_data.entity.Feat;
import ru.hackass122.pathfinderhelper.game_data.entity.Heritage;
import ru.hackass122.pathfinderhelper.game_data.entity.SpecialAbility;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;
import ru.hackass122.pathfinderhelper.game_data.mapper.AncestryDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.FeatDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.HeritageDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpecialAbilityDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.TraitDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.service.FeatService;
import ru.hackass122.pathfinderhelper.game_data.service.HeritageService;
import ru.hackass122.pathfinderhelper.game_data.service.SpecialAbilityService;
import ru.hackass122.pathfinderhelper.game_data.service.TraitService;

import java.util.HashSet;
import java.util.Set;

@Component
public class AncestryDtoMapperImpl implements AncestryDtoMapper {

    private final SpecialAbilityService specialAbilityService;
    private final HeritageService heritageService;
    private final FeatService featService;
    private final TraitService traitService;

    private final SpecialAbilityDtoMapper specialAbilityDtoMapper;
    private final HeritageDtoMapper heritageDtoMapper;
    private final FeatDtoMapper featDtoMapper;
    private final TraitDtoMapper traitDtoMapper;

    public AncestryDtoMapperImpl(SpecialAbilityService specialAbilityService, HeritageService heritageService,
                                 FeatService featService, TraitService traitService,
                                 SpecialAbilityDtoMapper specialAbilityDtoMapper, HeritageDtoMapper heritageDtoMapper,
                                 FeatDtoMapper featDtoMapper, TraitDtoMapper traitDtoMapper) {
        this.specialAbilityService = specialAbilityService;
        this.heritageService = heritageService;
        this.featService = featService;
        this.traitService = traitService;
        this.specialAbilityDtoMapper = specialAbilityDtoMapper;
        this.heritageDtoMapper = heritageDtoMapper;
        this.featDtoMapper = featDtoMapper;
        this.traitDtoMapper = traitDtoMapper;
    }

    @Override
    public AncestryResponseDto entityToResponseDto(Ancestry ancestry) {

        Set<SpecialAbilityResponseDto> specialAbilityResponseDtos = new HashSet<>();
        Set<HeritageResponseDto> heritageResponseDtos = new HashSet<>();
        Set<FeatResponseDto> featResponseDtos = new HashSet<>();
        Set<TraitResponseDto> traitResponseDtos = new HashSet<>();

        for (SpecialAbility specialAbility : ancestry.getSpecialAbilities()) {
            specialAbilityResponseDtos.add(specialAbilityDtoMapper.entityToResponseDto(specialAbility));
        }

        for (Heritage heritage : ancestry.getHeritages()) {
            heritageResponseDtos.add(heritageDtoMapper.entityToResponseDto(heritage));
        }

        for (Feat feat : ancestry.getAncestryFeats()) {
            featResponseDtos.add(featDtoMapper.entityToResponseDto(feat));
        }

        for (Trait trait : ancestry.getTraits()) {
            traitResponseDtos.add(traitDtoMapper.entityToResponseDto(trait));
        }

        return new AncestryResponseDto(ancestry.getCode(),
                ancestry.getName(),
                ancestry.getDescription(),
                ancestry.getHitPoints(),
                ancestry.getSize(),
                ancestry.getSpeed(),
                ancestry.getAttributeModifiers().getBoosts(),
                ancestry.getAttributeModifiers().getFlaws(),
                ancestry.getLanguages(),
                specialAbilityResponseDtos,
                heritageResponseDtos,
                featResponseDtos,
                traitResponseDtos,
                ancestry.isLegacy());
    }

    @Override
    public Ancestry creationRequestDtoToEntity(AncestryCreationRequestDto ancestryCreationRequestDto) {

        AttributeModifiers attributeModifiers = new AttributeModifiers(ancestryCreationRequestDto.boosts(),
                ancestryCreationRequestDto.flaws());

        Set<SpecialAbility> specialAbilities = specialAbilityService
                .getSpecialAbilitiesByCodes(ancestryCreationRequestDto.specialAbilitiesCodes());

        Set<Heritage> heritages = heritageService.getHeritagesByCodes(ancestryCreationRequestDto.heritagesCodes());

        Set<Feat> ancestryFeats = featService.getFeatsByCodes(ancestryCreationRequestDto.ancestryFeatsCodes());

        Set<Trait> traits = traitService.getTraitsByCodes(ancestryCreationRequestDto.traitsCodes());

        return new Ancestry(ancestryCreationRequestDto.hitPoints(),
                ancestryCreationRequestDto.size(),
                ancestryCreationRequestDto.speed(),
                attributeModifiers,
                ancestryCreationRequestDto.languages(),
                specialAbilities,
                heritages,
                ancestryFeats,
                traits,
                null,
                ancestryCreationRequestDto.name(),
                ancestryCreationRequestDto.description(),
                ancestryCreationRequestDto.legacy(),
                null);
    }
}
