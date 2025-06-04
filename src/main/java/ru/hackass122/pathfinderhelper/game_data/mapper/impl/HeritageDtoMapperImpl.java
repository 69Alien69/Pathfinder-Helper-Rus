package ru.hackass122.pathfinderhelper.game_data.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.dto.response.FeatResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.HeritageResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Feat;
import ru.hackass122.pathfinderhelper.game_data.entity.Heritage;
import ru.hackass122.pathfinderhelper.game_data.entity.SpecialAbility;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;
import ru.hackass122.pathfinderhelper.game_data.mapper.FeatDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.HeritageDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpecialAbilityDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.TraitDtoMapper;

import java.util.HashSet;
import java.util.Set;

@Component
public class HeritageDtoMapperImpl implements HeritageDtoMapper {

    private final TraitDtoMapper traitDtoMapper;
    private final SpecialAbilityDtoMapper specialAbilityDtoMapper;
    private final FeatDtoMapper featDtoMapper;

    public HeritageDtoMapperImpl(TraitDtoMapper traitDtoMapper, SpecialAbilityDtoMapper specialAbilityDtoMapper, FeatDtoMapper featDtoMapper) {
        this.traitDtoMapper = traitDtoMapper;
        this.specialAbilityDtoMapper = specialAbilityDtoMapper;
        this.featDtoMapper = featDtoMapper;
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
}
