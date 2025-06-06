package ru.hackass122.pathfinderhelper.game_data.service;

import ru.hackass122.pathfinderhelper.game_data.dto.request.EffectCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.EffectResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.EffectCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;

import java.util.Set;

public interface EffectService {
    Set<EffectResponseDto> getAllEffectResponseDtos();
    Set<Effect> getEffectsByCodes(Set<String> codes);
    EffectResponseDto getEffectResponseDtoByCode(String code);
    EffectCreationResponseDto getEffectCreationOptions();
    EffectResponseDto createFeat(EffectCreationRequestDto effectCreationRequestDto);
}
