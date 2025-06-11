package ru.hackass122.pathfinderhelper.game_data.mapper;

import ru.hackass122.pathfinderhelper.game_data.dto.response.PrerequisiteResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.prerequisite.Prerequisite;

public interface PrerequisiteDtoMapper {
    PrerequisiteResponseDto entityToResponseDto(Prerequisite prerequisite);
}
