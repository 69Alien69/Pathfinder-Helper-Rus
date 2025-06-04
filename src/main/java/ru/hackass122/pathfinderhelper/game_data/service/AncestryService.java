package ru.hackass122.pathfinderhelper.game_data.service;

import ru.hackass122.pathfinderhelper.game_data.dto.request.AncestryCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.AncestryCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.AncestryResponseDto;

import java.util.List;


public interface AncestryService {
    AncestryResponseDto getAncestryDtoByCode(String code);
    List<AncestryResponseDto> getAllAncestriesDto();
    AncestryResponseDto createAncestry(AncestryCreationRequestDto ancestryCreationRequestDto);
    AncestryCreationResponseDto getAncestryCreationOptions();
}
