package ru.hackass122.pathfinderhelper.game_data.mapper;

import ru.hackass122.pathfinderhelper.game_data.dto.request.FeatCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.FeatResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Feat;

public interface FeatDtoMapper {
    FeatResponseDto entityToResponseDto(Feat feat);
    Feat creationRequestDtoToEntity(FeatCreationRequestDto featCreationRequestDto);
}
