package ru.hackass122.pathfinderhelper.game_data.mapper;

import ru.hackass122.pathfinderhelper.game_data.dto.request.AncestryCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.AncestryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Ancestry;

public interface AncestryDtoMapper {

    AncestryResponseDto entityToResponseDto(Ancestry ancestry);
    Ancestry creationRequestDtoToEntity(AncestryCreationRequestDto ancestryCreationRequestDto);
}
