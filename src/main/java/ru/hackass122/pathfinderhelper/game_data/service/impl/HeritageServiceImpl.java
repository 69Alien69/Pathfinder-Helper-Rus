package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.ProficiencyRank;
import ru.hackass122.pathfinderhelper.common.enums.Size;
import ru.hackass122.pathfinderhelper.common.enums.Skill;
import ru.hackass122.pathfinderhelper.common.util.EntityCodeGenerator;
import ru.hackass122.pathfinderhelper.game_data.dto.request.HeritageCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.FeatResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.HeritageResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.HeritageCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Heritage;
import ru.hackass122.pathfinderhelper.game_data.mapper.HeritageDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.HeritageRepository;
import ru.hackass122.pathfinderhelper.game_data.service.FeatService;
import ru.hackass122.pathfinderhelper.game_data.service.HeritageService;
import ru.hackass122.pathfinderhelper.game_data.service.SpecialAbilityService;
import ru.hackass122.pathfinderhelper.game_data.service.TraitService;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class HeritageServiceImpl implements HeritageService {

    private final HeritageRepository heritageRepository;
    private final HeritageDtoMapper heritageDtoMapper;

    private final TraitService traitService;
    private final SpecialAbilityService specialAbilityService;
    private final FeatService featService;

    private static final String TYPE = "Heritage";

    public HeritageServiceImpl(HeritageRepository heritageRepository, HeritageDtoMapper heritageDtoMapper,
                               TraitService traitService, SpecialAbilityService specialAbilityService,
                               FeatService featService) {
        this.heritageRepository = heritageRepository;
        this.heritageDtoMapper = heritageDtoMapper;
        this.traitService = traitService;
        this.specialAbilityService = specialAbilityService;
        this.featService = featService;
    }

    @Override
    public Set<Heritage> getHeritagesByCodes(Set<String> codes) {
        return heritageRepository.findHeritageByCodeIn(codes);
    }

    @Override
    public Set<HeritageResponseDto> getAllHeritageResponseDtos() {
        List<Heritage> heritages = heritageRepository.findAll();
        Set<HeritageResponseDto> heritageResponseDtos = new HashSet<>();
        for (Heritage heritage : heritages) {
            heritageResponseDtos.add(heritageDtoMapper.entityToResponseDto(heritage));
        }
        return heritageResponseDtos;
    }

    @Override
    public HeritageResponseDto getHeritageResponseDtoByCode(String heritageCode) {
        Heritage heritage = heritageRepository.findHeritageByCode(heritageCode).orElseThrow();
        return heritageDtoMapper.entityToResponseDto(heritage);
    }

    @Override
    public HeritageCreationResponseDto getHeritageCreationOptions() {
        Set<TraitResponseDto> traitResponseDtos = traitService.getAllTraitResponseDtos();
        Set<Size> sizes = EnumSet.allOf(Size.class);
        Set<Attribute> attributes = EnumSet.allOf(Attribute.class);
        Set<SpecialAbilityResponseDto> specialAbilityResponseDtos =
                specialAbilityService.getAllSpecialAbilityResponseDtos();
        Set<Language> languages = EnumSet.allOf(Language.class);
        Set<Skill> skills = EnumSet.allOf(Skill.class);
        Set<ProficiencyRank> proficiencyRanks = EnumSet.allOf(ProficiencyRank.class);
        String resistances = "mockResistances";
        Set<FeatResponseDto> heritageFeatResponseDtos = featService.getAllFeatResponseDtos();
        return new HeritageCreationResponseDto(traitResponseDtos, sizes, attributes, specialAbilityResponseDtos,
                languages, skills, proficiencyRanks, resistances, heritageFeatResponseDtos);
    }


    @Override
    public HeritageResponseDto createHeritage(HeritageCreationRequestDto heritageCreationRequestDto) {
        Heritage heritage = heritageDtoMapper.creationRequestDtoToEntity(heritageCreationRequestDto);
        heritage.setCode(EntityCodeGenerator.generateForOfficialComponent(heritage.getName(),
                TYPE,
                heritage.isLegacy()));
        heritage = heritageRepository.save(heritage);
        return heritageDtoMapper.entityToResponseDto(heritage);
    }
}
