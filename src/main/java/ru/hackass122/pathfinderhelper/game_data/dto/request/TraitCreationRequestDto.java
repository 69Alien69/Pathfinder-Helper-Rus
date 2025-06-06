package ru.hackass122.pathfinderhelper.game_data.dto.request;

import ru.hackass122.pathfinderhelper.common.enums.TraitCategory;

public record TraitCreationRequestDto(String name,
                                     String description,
                                     Boolean legacy,
                                     TraitCategory traitCategory) {
}
