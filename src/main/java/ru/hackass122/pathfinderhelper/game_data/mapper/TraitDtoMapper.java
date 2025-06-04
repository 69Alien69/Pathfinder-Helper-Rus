package ru.hackass122.pathfinderhelper.game_data.mapper;

import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;

public interface TraitDtoMapper {
    TraitResponseDto entityToResponseDto(Trait trait);
}
