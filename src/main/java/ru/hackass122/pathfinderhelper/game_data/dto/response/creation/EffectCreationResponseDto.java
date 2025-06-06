package ru.hackass122.pathfinderhelper.game_data.dto.response.creation;

import ru.hackass122.pathfinderhelper.common.enums.EffectType;

import java.util.Map;
import java.util.Set;

public record EffectCreationResponseDto(Set<EffectType> types,
                                        Map<EffectType, Map<String, Object>> dataPerType) {
}
