package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.game_data.dto.response.PrerequisiteResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.prerequisite.Prerequisite;
import ru.hackass122.pathfinderhelper.game_data.mapper.PrerequisiteDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.PrerequisiteRepository;
import ru.hackass122.pathfinderhelper.game_data.service.PrerequisiteService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PrerequisiteServiceImpl implements PrerequisiteService {

    private final PrerequisiteRepository prerequisiteRepository;
    private final PrerequisiteDtoMapper prerequisiteDtoMapper;

    public PrerequisiteServiceImpl(PrerequisiteRepository prerequisiteRepository, PrerequisiteDtoMapper prerequisiteDtoMapper) {
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
}
