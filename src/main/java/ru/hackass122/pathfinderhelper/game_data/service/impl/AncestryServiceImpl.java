package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.Size;
import ru.hackass122.pathfinderhelper.common.util.EntityCodeGenerator;
import ru.hackass122.pathfinderhelper.game_data.dto.request.AncestryCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.AncestryCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.AncestryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Ancestry;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.AncestryRepository;
import ru.hackass122.pathfinderhelper.game_data.mapper.AncestryDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.service.AncestryService;
import ru.hackass122.pathfinderhelper.game_data.service.SpecialAbilityService;
import ru.hackass122.pathfinderhelper.game_data.service.TraitService;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Service
public class AncestryServiceImpl implements AncestryService {

    private final AncestryDtoMapper ancestryDtoMapper;
    private final AncestryRepository ancestryRepository;
    private final SpecialAbilityService specialAbilityService;
    private final TraitService traitService;

    private final static String TYPE = "Ancestry";

    public AncestryServiceImpl(AncestryDtoMapper ancestryDtoMapper, AncestryRepository ancestryRepository,
                               SpecialAbilityService specialAbilityService, TraitService traitService) {
        this.ancestryDtoMapper = ancestryDtoMapper;
        this.ancestryRepository = ancestryRepository;
        this.specialAbilityService = specialAbilityService;
        this.traitService = traitService;
    }

    @Override
    public AncestryResponseDto getAncestryDtoByCode(String code) {
        Ancestry ancestry = ancestryRepository.findAncestryByCode(code).orElseThrow();
        return ancestryDtoMapper.entityToResponseDto(ancestry);
    }

    @Override
    public List<AncestryResponseDto> getAllAncestriesDto() {
        List<Ancestry> ancestries = ancestryRepository.findAll();
        List<AncestryResponseDto> ancestryResponseDtos = new ArrayList<>(ancestries.size());
        for(Ancestry ancestry : ancestries) {
            ancestryResponseDtos.add(ancestryDtoMapper.entityToResponseDto(ancestry));
        }
        return ancestryResponseDtos;
    }

    @Override
    public AncestryResponseDto createAncestry(AncestryCreationRequestDto ancestryCreationRequestDto) {
        Ancestry ancestry = ancestryDtoMapper.creationRequestDtoToEntity(ancestryCreationRequestDto);
        ancestry.setCode(EntityCodeGenerator.generateForOfficialComponent(ancestryCreationRequestDto.name(), TYPE,
                ancestryCreationRequestDto.legacy()));
        ancestry = ancestryRepository.save(ancestry);
        return ancestryDtoMapper.entityToResponseDto(ancestry);
    }

    @Override
    public AncestryCreationResponseDto getAncestryCreationOptions() {
        Set<Size> sizes = EnumSet.allOf(Size.class);
        Set<Attribute> attributes = EnumSet.allOf(Attribute.class);
        Set<Language> languages = EnumSet.allOf(Language.class);
        Set<SpecialAbilityResponseDto> specialAbilityResponseDtos = specialAbilityService.getAllSpecialAbilityDtos();
        Set<TraitResponseDto> traitResponseDtos = traitService.getAllTraitResponseDtos();
        return new AncestryCreationResponseDto(sizes, attributes,
                languages, specialAbilityResponseDtos, traitResponseDtos);
    }
}
