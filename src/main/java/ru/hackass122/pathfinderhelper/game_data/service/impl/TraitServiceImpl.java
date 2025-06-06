package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.common.enums.TraitCategory;
import ru.hackass122.pathfinderhelper.common.util.EntityCodeGenerator;
import ru.hackass122.pathfinderhelper.game_data.dto.request.TraitCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.TraitCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;
import ru.hackass122.pathfinderhelper.game_data.mapper.TraitDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.TraitRepository;
import ru.hackass122.pathfinderhelper.game_data.service.TraitService;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TraitServiceImpl implements TraitService {

    private final TraitRepository traitRepository;
    private final TraitDtoMapper traitDtoMapper;

    private static final String TYPE = "Trait";

    public TraitServiceImpl(TraitRepository traitRepository, TraitDtoMapper traitDtoMapper) {
        this.traitRepository = traitRepository;
        this.traitDtoMapper = traitDtoMapper;
    }

    @Override
    public Set<Trait> getTraitByCodes(Set<String> codes) {
        return traitRepository.findTraitByCodeIn(codes).orElseThrow();
    }

    @Override
    public Set<TraitResponseDto> getAllTraitResponseDtos() {
        List<Trait> traits = traitRepository.findAll();
        Set<TraitResponseDto> traitResponseDtos = new HashSet<>();
        for(Trait trait : traits) {
            traitResponseDtos.add(traitDtoMapper.entityToResponseDto(trait));
        }
        return traitResponseDtos;
    }

    @Override
    public TraitResponseDto getTraitResponseDtoByCode(String code) {
        Trait trait = traitRepository.findTraitByCode(code).orElseThrow();
        return traitDtoMapper.entityToResponseDto(trait);
    }

    @Override
    public TraitCreationResponseDto getTraitCreationOptions() {
        Set<TraitCategory> traitCategories = EnumSet.allOf(TraitCategory.class);
        return new TraitCreationResponseDto(traitCategories);
    }

    @Override
    public TraitResponseDto createTrait(TraitCreationRequestDto traitCreationRequestDto) {
        String code = EntityCodeGenerator.generateForOfficialComponent(traitCreationRequestDto.name(), TYPE,
                traitCreationRequestDto.legacy());
        Trait trait = new Trait(code,
                traitCreationRequestDto.name(),
                traitCreationRequestDto.description(),
                traitCreationRequestDto.legacy(),
                null,
                traitCreationRequestDto.traitCategory());
        return traitDtoMapper.entityToResponseDto(trait);
    }
}
