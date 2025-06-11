package ru.hackass122.pathfinderhelper.game_data.dto.request;

import ru.hackass122.pathfinderhelper.common.enums.PrerequisiteType;

import java.util.Map;

public record PrerequisiteCreationRequestDto(String name,
                                             String description,
                                             Boolean legacy,
                                             PrerequisiteType type,
                                             Map<String, Object> data) {
}
