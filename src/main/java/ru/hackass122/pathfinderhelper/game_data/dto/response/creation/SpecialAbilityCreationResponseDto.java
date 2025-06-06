package ru.hackass122.pathfinderhelper.game_data.dto.response.creation;

import ru.hackass122.pathfinderhelper.game_data.dto.response.EffectResponseDto;

import java.util.Set;

public record SpecialAbilityCreationResponseDto(Set<EffectResponseDto> effectResponseDtos) {
}
