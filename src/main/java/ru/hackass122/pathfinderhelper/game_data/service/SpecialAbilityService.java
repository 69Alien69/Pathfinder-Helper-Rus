package ru.hackass122.pathfinderhelper.game_data.service;

import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.SpecialAbility;

import java.util.List;
import java.util.Set;

public interface SpecialAbilityService {
    Set<SpecialAbility> getSpecialAbilitiesByCodes(Set<String> codes);
    Set<SpecialAbilityResponseDto> getAllSpecialAbilityDtos();
}
