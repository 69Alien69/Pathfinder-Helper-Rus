package ru.hackass122.pathfinderhelper.game_data.dto.response;

import ru.hackass122.pathfinderhelper.common.enums.EffectType;

import java.util.Map;

public record EffectResponseDto(String code,
                                String name,
                                String description,
                                Boolean legacy,
                                EffectType type,
                                Map<String, Object> data) {
}
