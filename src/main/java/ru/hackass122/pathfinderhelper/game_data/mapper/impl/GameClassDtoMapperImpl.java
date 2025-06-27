package ru.hackass122.pathfinderhelper.game_data.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.dto.request.GameClassCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.FeatResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.GameClassResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellCastingEntryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Feat;
import ru.hackass122.pathfinderhelper.game_data.entity.GameClass;
import ru.hackass122.pathfinderhelper.game_data.entity.SpecialAbility;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;
import ru.hackass122.pathfinderhelper.game_data.entity.spellcasting.SpellCastingEntry;
import ru.hackass122.pathfinderhelper.game_data.mapper.FeatDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.GameClassDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpecialAbilityDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpellCastingEntryDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.mapper.TraitDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.service.FeatService;
import ru.hackass122.pathfinderhelper.game_data.service.SpecialAbilityService;
import ru.hackass122.pathfinderhelper.game_data.service.SpellCastingEntryService;
import ru.hackass122.pathfinderhelper.game_data.service.TraitService;

import java.util.HashSet;
import java.util.Set;

@Component
public class GameClassDtoMapperImpl implements GameClassDtoMapper {

    private final TraitDtoMapper traitDtoMapper;
    private final FeatDtoMapper featDtoMapper;
    private final SpecialAbilityDtoMapper specialAbilityDtoMapper;
    private final SpellCastingEntryDtoMapper spellCastingEntryDtoMapper;

    private final TraitService traitService;
    private final FeatService featService;
    private final SpecialAbilityService specialAbilityService;
    private final SpellCastingEntryService spellCastingEntryService;

    public GameClassDtoMapperImpl(TraitDtoMapper traitDtoMapper, FeatDtoMapper featDtoMapper,
                                  SpecialAbilityDtoMapper specialAbilityDtoMapper,
                                  SpellCastingEntryDtoMapper spellCastingEntryDtoMapper, TraitService traitService,
                                  FeatService featService, SpecialAbilityService specialAbilityService,
                                  SpellCastingEntryService spellCastingEntryService) {
        this.traitDtoMapper = traitDtoMapper;
        this.featDtoMapper = featDtoMapper;
        this.specialAbilityDtoMapper = specialAbilityDtoMapper;
        this.spellCastingEntryDtoMapper = spellCastingEntryDtoMapper;
        this.traitService = traitService;
        this.featService = featService;
        this.specialAbilityService = specialAbilityService;
        this.spellCastingEntryService = spellCastingEntryService;
    }

    @Override
    public GameClassResponseDto entityToResponseDto(GameClass gameClass) {

        Set<TraitResponseDto> traits = new HashSet<>();
        Set<FeatResponseDto> feats = new HashSet<>();
        Set<SpecialAbilityResponseDto> specialAbilities = new HashSet<>();
        Set<SpellCastingEntryResponseDto> spellCastingEntries = new HashSet<>();

        for (Trait trait : gameClass.getTraits()) {
            traits.add(traitDtoMapper.entityToResponseDto(trait));
        }

        for (Feat feat : gameClass.getGameClassFeats()) {
            feats.add(featDtoMapper.entityToResponseDto(feat));
        }

        for (SpecialAbility specialAbility : gameClass.getSpecialAbilities()) {
            specialAbilities.add(specialAbilityDtoMapper.entityToResponseDto(specialAbility));
        }

        for (SpellCastingEntry spellCastingEntry : gameClass.getSpellCastingEntries()) {
            spellCastingEntries.add(spellCastingEntryDtoMapper.entityToResponseDto(spellCastingEntry));
        }

        return new GameClassResponseDto(traits,
                gameClass.getCode(),
                gameClass.getName(),
                gameClass.getDescription(),
                gameClass.isLegacy(),
                gameClass.getHitDie(),
                gameClass.getKeyAbilities(),
                gameClass.getInitialPerception(),
                gameClass.getInitialSaveThrowsProficiencies(),
                gameClass.getInitialSkillProficiencies(),
                gameClass.getInitialWeaponProficiencies(),
                gameClass.getInitialArmorProficiencies(),
                feats,
                specialAbilities,
                gameClass.isSpellCaster(),
                spellCastingEntries);
    }

    @Override
    public GameClass creationRequestDtoToEntity(GameClassCreationRequestDto creationRequestDto) {
        Set<Trait> traits = traitService.getTraitByCodes(creationRequestDto.traitCodes());
        Set<Feat> feats = featService.getFeatsByCodes(creationRequestDto.gameClassFeatCodes());
        Set<SpecialAbility> specialAbilities = specialAbilityService
                .getSpecialAbilitiesByCodes(creationRequestDto.specialAbilityCodes());
        Set<SpellCastingEntry> spellCastingEntries = spellCastingEntryService
                .getSpellCastingEntriesByIds(creationRequestDto.spellCastingEntryIds());

        return new GameClass(traits,
                null,
                creationRequestDto.name(),
                creationRequestDto.description(),
                creationRequestDto.legacy(),
                null,
                creationRequestDto.hitDie(),
                creationRequestDto.keyAbilities(),
                creationRequestDto.initialPerception(),
                creationRequestDto.initialSaveThrowsProficiencies(),
                creationRequestDto.initialSkillProficiencies(),
                creationRequestDto.initialWeaponProficiencies(),
                creationRequestDto.initialArmorProficiencies(),
                feats,
                specialAbilities,
                creationRequestDto.isSpellCaster(),
                spellCastingEntries);
        }
}
