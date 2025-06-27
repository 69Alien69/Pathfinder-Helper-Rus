package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.common.enums.ArmorCategory;
import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.ProficiencyRank;
import ru.hackass122.pathfinderhelper.common.enums.SaveThrow;
import ru.hackass122.pathfinderhelper.common.enums.Skill;
import ru.hackass122.pathfinderhelper.common.enums.WeaponCategory;
import ru.hackass122.pathfinderhelper.common.util.EntityCodeGenerator;
import ru.hackass122.pathfinderhelper.game_data.dto.request.GameClassCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.FeatResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.GameClassResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellCastingEntryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.GameClassCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.GameClass;
import ru.hackass122.pathfinderhelper.game_data.mapper.GameClassDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.GameClassRepository;
import ru.hackass122.pathfinderhelper.game_data.service.FeatService;
import ru.hackass122.pathfinderhelper.game_data.service.GameClassService;
import ru.hackass122.pathfinderhelper.game_data.service.SpecialAbilityService;
import ru.hackass122.pathfinderhelper.game_data.service.SpellCastingEntryService;
import ru.hackass122.pathfinderhelper.game_data.service.TraitService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GameClassServiceImpl implements GameClassService {

    private static final String TYPE = "Class";

    private final GameClassRepository gameClassRepository;
    private final GameClassDtoMapper gameClassDtoMapper;

    private final TraitService traitService;
    private final FeatService featService;
    private final SpecialAbilityService specialAbilityService;
    private final SpellCastingEntryService spellCastingEntryService;

    public GameClassServiceImpl(GameClassRepository gameClassRepository, GameClassDtoMapper gameClassDtoMapper, TraitService traitService, FeatService featService, SpecialAbilityService specialAbilityService, SpellCastingEntryService spellCastingEntryService) {
        this.gameClassRepository = gameClassRepository;
        this.gameClassDtoMapper = gameClassDtoMapper;
        this.traitService = traitService;
        this.featService = featService;
        this.specialAbilityService = specialAbilityService;
        this.spellCastingEntryService = spellCastingEntryService;
    }

    @Override
    public Set<GameClassResponseDto> getAllGameClassResponseDtos() {

        List<GameClass> gameClasses = gameClassRepository.findAll();
        Set<GameClassResponseDto> gameClassResponseDtos = new HashSet<>();

        for (GameClass gameClass : gameClasses) {
            gameClassResponseDtos.add(gameClassDtoMapper.entityToResponseDto(gameClass));
        }

        return gameClassResponseDtos;
    }

    @Override
    public GameClassResponseDto getGameClassResponseDtoByCode(String code) {
        GameClass gameClass = gameClassRepository.findGameClassByCode(code);
        return gameClassDtoMapper.entityToResponseDto(gameClass);
    }

    @Override
    public GameClassCreationResponseDto getGameClassCreationOptions() {
        Set<TraitResponseDto> traitResponseDtos = traitService.getAllTraitResponseDtos();
        Set<Attribute> allAbilities = Set.of(Attribute.values());
        Set<ProficiencyRank> allProficiencyRanks = Set.of(ProficiencyRank.values());
        Set<SaveThrow> allSaveThrows = Set.of(SaveThrow.values());
        Set<Skill> allSkills = Set.of(Skill.values());
        Set<WeaponCategory> allWeaponCategories = Set.of(WeaponCategory.values());
        Set<ArmorCategory> allArmorCategories = Set.of(ArmorCategory.values());
        Set<FeatResponseDto> allGameClassFeats = featService.getAllFeatResponseDtos();
        Set<SpecialAbilityResponseDto> allSpecialAbilities = specialAbilityService.getAllSpecialAbilityResponseDtos();
        Set<SpellCastingEntryResponseDto> allSpellCastingEntries = spellCastingEntryService.getAllSpellCastingEntriesResponseDtos();
        return new GameClassCreationResponseDto(
                traitResponseDtos,
                allAbilities,
                allProficiencyRanks,
                allSaveThrows,
                allSkills,
                allWeaponCategories,
                allArmorCategories,
                allGameClassFeats,
                allSpecialAbilities,
                allSpellCastingEntries);
    }

    @Override
    public GameClassResponseDto createGameClass(GameClassCreationRequestDto gameClassCreationRequestDto) {
        GameClass gameClass = gameClassDtoMapper.creationRequestDtoToEntity(gameClassCreationRequestDto);
        gameClass.setCode(EntityCodeGenerator.generateForOfficialComponent(gameClass.getName(), TYPE, gameClass.isLegacy()));
        gameClass = gameClassRepository.save(gameClass);
        return gameClassDtoMapper.entityToResponseDto(gameClass);
    }
}
