package ru.hackass122.pathfinderhelper.game_data.service;

import ru.hackass122.pathfinderhelper.game_data.dto.request.GameClassCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.GameClassResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.GameClassCreationResponseDto;

import java.util.Set;

public interface GameClassService {
    Set<GameClassResponseDto> getAllGameClassResponseDtos();
    GameClassResponseDto getGameClassResponseDtoByCode(String code);
    GameClassCreationResponseDto getGameClassCreationOptions();
    GameClassResponseDto createGameClass(GameClassCreationRequestDto gameClassCreationRequestDto);
}
