package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.common.enums.PrerequisiteType;
import ru.hackass122.pathfinderhelper.game_data.dto.request.PrerequisiteCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.PrerequisiteResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.PrerequisiteCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.prerequisite.Prerequisite;
import ru.hackass122.pathfinderhelper.game_data.mapper.PrerequisiteDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.PrerequisiteRepository;
import ru.hackass122.pathfinderhelper.game_data.service.PrerequisiteService;
import ru.hackass122.pathfinderhelper.game_data.util.PrerequisiteFactory;
import ru.hackass122.pathfinderhelper.game_data.util.PrerequisiteMetadataProvider;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class PrerequisiteServiceImpl implements PrerequisiteService {

    private final PrerequisiteRepository prerequisiteRepository;
    private final PrerequisiteDtoMapper prerequisiteDtoMapper;

    public PrerequisiteServiceImpl(PrerequisiteRepository prerequisiteRepository,
                                   PrerequisiteDtoMapper prerequisiteDtoMapper) {
        this.prerequisiteRepository = prerequisiteRepository;
        this.prerequisiteDtoMapper = prerequisiteDtoMapper;
    }

    @Override
    public Set<Prerequisite> getPrerequisitesByCodes(Set<String> codes) {
        return prerequisiteRepository.findAllByCodeIn(codes);
    }

    @Override
    public Set<PrerequisiteResponseDto> getAllPrerequisiteDtos() {
        List<Prerequisite> prerequisites = prerequisiteRepository.findAll();

        Set<PrerequisiteResponseDto> prerequisiteResponseDtos = new HashSet<>();

        for(Prerequisite prerequisite : prerequisites) {
            prerequisiteResponseDtos.add(prerequisiteDtoMapper.entityToResponseDto(prerequisite));
        }
        return prerequisiteResponseDtos;
    }

    @Override
    public PrerequisiteResponseDto getPrerequisiteDtoByCode(String code) {

        Prerequisite prerequisite = prerequisiteRepository.findPrerequisiteByCode(code).orElseThrow();

        return prerequisiteDtoMapper.entityToResponseDto(prerequisite);
    }

    @Override
    public PrerequisiteResponseDto createPrerequisite(PrerequisiteCreationRequestDto prerequisiteCreationRequestDto) {

        Prerequisite prerequisite = PrerequisiteFactory.createPrerequisiteFrom(prerequisiteCreationRequestDto.name(),
                prerequisiteCreationRequestDto.description(),
                prerequisiteCreationRequestDto.legacy(),
                prerequisiteCreationRequestDto.type(),
                prerequisiteCreationRequestDto.data());

        return prerequisiteDtoMapper.entityToResponseDto(prerequisite);
    }

    @Override
    public PrerequisiteCreationResponseDto getPrerequisiteCreationOptions() {
        Set<PrerequisiteType> prerequisiteTypes = EnumSet.allOf(PrerequisiteType.class);
        Map<PrerequisiteType, Map<String, Object>> dataPerType = new EnumMap<>(PrerequisiteType.class);
        for (PrerequisiteType type : PrerequisiteType.values()) {
            dataPerType.put(type, PrerequisiteMetadataProvider.getMetadataFor(type));
        }
        return new PrerequisiteCreationResponseDto(prerequisiteTypes, dataPerType);
    }
}
