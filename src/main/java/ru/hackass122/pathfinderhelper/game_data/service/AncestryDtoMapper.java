package ru.hackass122.pathfinderhelper.game_data.service;

import ru.hackass122.pathfinderhelper.game_data.dto.response.AncestryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Ancestry;

public interface AncestryDtoMapper {

    AncestryResponseDto ancestryToResponseDto(Ancestry ancestry);
}
