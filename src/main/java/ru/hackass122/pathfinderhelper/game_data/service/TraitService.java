package ru.hackass122.pathfinderhelper.game_data.service;

import ru.hackass122.pathfinderhelper.game_data.dto.request.TraitCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.TraitCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;

import java.util.Set;

public interface TraitService {
    Set<Trait> getTraitByCodes(Set<String> codes);
    Set<TraitResponseDto> getAllTraitResponseDtos();
    TraitResponseDto getTraitResponseDtoByCode(String code);
    TraitCreationResponseDto getTraitCreationOptions();
    TraitResponseDto createTrait(TraitCreationRequestDto traitCreationRequestDto);
}
