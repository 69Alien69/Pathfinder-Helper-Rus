package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;
import ru.hackass122.pathfinderhelper.game_data.mapper.TraitDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.TraitRepository;
import ru.hackass122.pathfinderhelper.game_data.service.TraitService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TraitServiceImpl implements TraitService {

    private final TraitRepository traitRepository;
    private final TraitDtoMapper traitDtoMapper;

    public TraitServiceImpl(TraitRepository traitRepository, TraitDtoMapper traitDtoMapper) {
        this.traitRepository = traitRepository;
        this.traitDtoMapper = traitDtoMapper;
    }

    @Override
    public Set<Trait> getTraitsByCodes(Set<String> codes) {
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
}
