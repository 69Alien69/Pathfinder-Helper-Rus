package ru.hackass122.pathfinderhelper.game_data.dto.response;

import java.util.Set;

public record FeatResponseDto(Set<TraitResponseDto> traitResponseDtos,
                              String code,
                              String name,
                              String description,
                              Boolean legacy,
                              Integer level,
                              Set<EffectResponseDto> effectResponseDtos,
                              String prerequisites) {
}
