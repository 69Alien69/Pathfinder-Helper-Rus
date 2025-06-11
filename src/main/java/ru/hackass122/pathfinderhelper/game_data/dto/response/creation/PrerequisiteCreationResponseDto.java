package ru.hackass122.pathfinderhelper.game_data.dto.response.creation;

import ru.hackass122.pathfinderhelper.common.enums.PrerequisiteType;

import java.util.Map;
import java.util.Set;

public record PrerequisiteCreationResponseDto(Set<PrerequisiteType> types,
                                              Map<PrerequisiteType, Map<String, Object>> dataPerType) {
}
