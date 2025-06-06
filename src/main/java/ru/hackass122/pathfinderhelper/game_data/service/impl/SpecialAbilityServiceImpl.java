package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.common.util.EntityCodeGenerator;
import ru.hackass122.pathfinderhelper.game_data.dto.request.SpecialAbilityCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.EffectResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.SpecialAbilityCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.SpecialAbility;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.SpecialAbilityRepository;
import ru.hackass122.pathfinderhelper.game_data.service.EffectService;
import ru.hackass122.pathfinderhelper.game_data.service.SpecialAbilityService;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpecialAbilityDtoMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SpecialAbilityServiceImpl implements SpecialAbilityService {

    private final SpecialAbilityRepository specialAbilityRepository;
    private final SpecialAbilityDtoMapper specialAbilityDtoMapper;
    private final EffectService effectService;

    private static final String TYPE = "Special Ability";

    public SpecialAbilityServiceImpl(SpecialAbilityRepository specialAbilityRepository, SpecialAbilityDtoMapper specialAbilityDtoMapper, EffectService effectService) {
        this.specialAbilityRepository = specialAbilityRepository;
        this.specialAbilityDtoMapper = specialAbilityDtoMapper;
        this.effectService = effectService;
    }

    @Override
    public Set<SpecialAbility> getSpecialAbilitiesByCodes(Set<String> codes) {
        return specialAbilityRepository.findByCodeIn(codes).orElseThrow();
    }

    @Override
    public Set<SpecialAbilityResponseDto> getAllSpecialAbilityResponseDtos() {
        List<SpecialAbility> specialAbilities = specialAbilityRepository.findAll();
        Set<SpecialAbilityResponseDto> specialAbilityResponseDtos = new HashSet<>();
        for(SpecialAbility specialAbility : specialAbilities) {
            specialAbilityResponseDtos.add(specialAbilityDtoMapper.entityToResponseDto(specialAbility));
        }
        return specialAbilityResponseDtos;
    }

    @Override
    public SpecialAbilityResponseDto getSpecialAbilityResponseDtoByCode(String specialAbilityCode) {
        SpecialAbility specialAbility = specialAbilityRepository.findSpecialAbilityByCode(specialAbilityCode)
                .orElseThrow();
        return specialAbilityDtoMapper.entityToResponseDto(specialAbility);
    }

    @Override
    public SpecialAbilityCreationResponseDto getSpecialAbilityCreationOptions() {
        Set<EffectResponseDto> effectResponseDtos = effectService.getAllEffectResponseDtos();
        return new SpecialAbilityCreationResponseDto(effectResponseDtos);
    }

    @Override
    public SpecialAbilityResponseDto createSpecialAbility(SpecialAbilityCreationRequestDto creationRequestDto) {
        SpecialAbility specialAbility = specialAbilityDtoMapper.creationRequestDtoToEntity(creationRequestDto);
        specialAbility.setCode(EntityCodeGenerator.generateForOfficialComponent(specialAbility.getName(),
                TYPE,
                specialAbility.isLegacy()));
        specialAbility = specialAbilityRepository.save(specialAbility);
        return specialAbilityDtoMapper.entityToResponseDto(specialAbility);
    }
}
