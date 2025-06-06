package ru.hackass122.pathfinderhelper.game_data.mapper;

import ru.hackass122.pathfinderhelper.game_data.dto.request.SpecialAbilityCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.SpecialAbility;

public interface SpecialAbilityDtoMapper {
    SpecialAbilityResponseDto entityToResponseDto(SpecialAbility specialAbility);
    SpecialAbility creationRequestDtoToEntity(SpecialAbilityCreationRequestDto specialAbilityCreationRequestDto);
}
