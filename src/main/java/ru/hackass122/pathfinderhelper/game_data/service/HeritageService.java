package ru.hackass122.pathfinderhelper.game_data.service;

import ru.hackass122.pathfinderhelper.game_data.dto.request.HeritageCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.HeritageResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.HeritageCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Heritage;

import java.util.Set;

public interface HeritageService {
    Set<Heritage> getHeritagesByCodes(Set<String> codes);
    Set<HeritageResponseDto> getAllHeritageResponseDtos();
    HeritageResponseDto getHeritageResponseDtoByCode(String heritageCode);
    HeritageCreationResponseDto getHeritageCreationOptions();
    HeritageResponseDto createHeritage(HeritageCreationRequestDto heritageCreationRequestDto);
}
