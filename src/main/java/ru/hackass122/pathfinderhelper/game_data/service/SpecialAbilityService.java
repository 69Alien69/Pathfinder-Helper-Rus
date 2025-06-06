package ru.hackass122.pathfinderhelper.game_data.service;

import ru.hackass122.pathfinderhelper.game_data.dto.request.SpecialAbilityCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.SpecialAbilityCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.SpecialAbility;

import java.util.Set;

public interface SpecialAbilityService {
    Set<SpecialAbility> getSpecialAbilitiesByCodes(Set<String> codes);
    Set<SpecialAbilityResponseDto> getAllSpecialAbilityResponseDtos();
    SpecialAbilityResponseDto getSpecialAbilityResponseDtoByCode(String specialAbilityCode);
    SpecialAbilityCreationResponseDto getSpecialAbilityCreationOptions();
    SpecialAbilityResponseDto createSpecialAbility(SpecialAbilityCreationRequestDto specialAbilityCreationRequestDto);
}
