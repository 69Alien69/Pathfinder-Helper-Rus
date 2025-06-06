package ru.hackass122.pathfinderhelper.game_data.dto.response.creation;

import ru.hackass122.pathfinderhelper.common.enums.TraitCategory;

import java.util.Set;

public record TraitCreationResponseDto(Set<TraitCategory> traitCategories) {
}
