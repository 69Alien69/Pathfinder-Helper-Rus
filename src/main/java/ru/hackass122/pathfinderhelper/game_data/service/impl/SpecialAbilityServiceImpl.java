package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.SpecialAbility;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.SpecialAbilityRepository;
import ru.hackass122.pathfinderhelper.game_data.service.SpecialAbilityService;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpecialAbilityDtoMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SpecialAbilityServiceImpl implements SpecialAbilityService {

    private final SpecialAbilityRepository specialAbilityRepository;
    private final SpecialAbilityDtoMapper specialAbilityDtoMapper;

    public SpecialAbilityServiceImpl(SpecialAbilityRepository specialAbilityRepository, SpecialAbilityDtoMapper specialAbilityDtoMapper) {
        this.specialAbilityRepository = specialAbilityRepository;
        this.specialAbilityDtoMapper = specialAbilityDtoMapper;
    }

    @Override
    public Set<SpecialAbility> getSpecialAbilitiesByCodes(Set<String> codes) {
        return specialAbilityRepository.findByCodeIn(codes).orElseThrow();
    }

    @Override
    public Set<SpecialAbilityResponseDto> getAllSpecialAbilityDtos() {
        List<SpecialAbility> specialAbilities = specialAbilityRepository.findAll();
        Set<SpecialAbilityResponseDto> specialAbilityResponseDtos = new HashSet<>();
        for(SpecialAbility specialAbility : specialAbilities) {
            specialAbilityResponseDtos.add(specialAbilityDtoMapper.entityToResponseDto(specialAbility));
        }
        return specialAbilityResponseDtos;
    }
}
