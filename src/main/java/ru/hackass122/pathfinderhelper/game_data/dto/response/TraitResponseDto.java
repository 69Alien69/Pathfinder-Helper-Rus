package ru.hackass122.pathfinderhelper.game_data.dto.response;

import ru.hackass122.pathfinderhelper.common.enums.TraitCategory;

public record TraitResponseDto(String code,
                               String name,
                               String description,
                               Boolean legacy,
                               TraitCategory traitCategory) {
}
