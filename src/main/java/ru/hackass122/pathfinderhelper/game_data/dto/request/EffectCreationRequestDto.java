package ru.hackass122.pathfinderhelper.game_data.dto.request;

import ru.hackass122.pathfinderhelper.common.enums.EffectType;

import java.util.Map;

public record EffectCreationRequestDto(String name,
                                       String description,
                                       Boolean legacy,
                                       EffectType effectType,
                                       Map<String, Object> data) {
}
