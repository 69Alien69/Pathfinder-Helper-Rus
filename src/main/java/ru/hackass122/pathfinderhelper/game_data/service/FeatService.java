package ru.hackass122.pathfinderhelper.game_data.service;

import ru.hackass122.pathfinderhelper.game_data.dto.request.FeatCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.FeatCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.FeatResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Feat;

import java.util.Set;

public interface FeatService {
    Set<Feat> getFeatsByCodes(Set<String> codes);
    Set<FeatResponseDto> getAllFeatResponseDtos();
    FeatResponseDto getFeatResponseDtoByCode(String code);
    FeatCreationResponseDto getFeatCreationOptions();
    FeatResponseDto createFeat(FeatCreationRequestDto featCreationRequestDto);
}
