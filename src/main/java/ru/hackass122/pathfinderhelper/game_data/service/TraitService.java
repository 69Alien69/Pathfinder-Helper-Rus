package ru.hackass122.pathfinderhelper.game_data.service;

import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;

import java.util.Set;

public interface TraitService {
    Set<Trait> getTraitsByCodes(Set<String> codes);
    Set<TraitResponseDto> getAllTraitResponseDtos();
}
