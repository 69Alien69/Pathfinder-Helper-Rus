package ru.hackass122.pathfinderhelper.game_data.dto.response;

import java.util.Set;

public record FeatCreationResponseDto(Set<TraitResponseDto> traitResponseDtos,
                                      Set<EffectResponseDto> effectResponseDtos,
                                      String prerequisites) {
}
