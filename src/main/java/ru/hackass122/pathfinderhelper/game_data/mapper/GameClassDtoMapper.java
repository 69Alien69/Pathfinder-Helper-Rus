package ru.hackass122.pathfinderhelper.game_data.mapper;

import ru.hackass122.pathfinderhelper.game_data.dto.request.GameClassCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.GameClassResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.GameClass;

public interface GameClassDtoMapper {
    GameClassResponseDto entityToResponseDto(GameClass gameClass);
    GameClass creationRequestDtoToEntity(GameClassCreationRequestDto creationRequestDto);
}
