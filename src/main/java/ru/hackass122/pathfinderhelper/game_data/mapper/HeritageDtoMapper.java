package ru.hackass122.pathfinderhelper.game_data.mapper;

import ru.hackass122.pathfinderhelper.game_data.dto.request.HeritageCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.HeritageResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Heritage;

public interface HeritageDtoMapper {
    HeritageResponseDto entityToResponseDto(Heritage heritage);
    Heritage creationRequestDtoToEntity(HeritageCreationRequestDto heritageCreationRequestDto);
}
