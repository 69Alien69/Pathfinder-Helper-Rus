package ru.hackass122.pathfinderhelper.game_data.dto.response.creation;

import ru.hackass122.pathfinderhelper.game_data.dto.response.EffectResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.PrerequisiteResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;

import java.util.Set;

public record FeatCreationResponseDto(Set<TraitResponseDto> traitResponseDtos,
                                      Set<EffectResponseDto> effectResponseDtos,
                                      Set<PrerequisiteResponseDto> prerequisites) {
}
