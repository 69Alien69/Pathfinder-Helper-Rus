package ru.hackass122.pathfinderhelper.game_data.dto.request;

import java.util.Set;

public record FeatCreationRequestDto(Set<String> traitCodes,
                                     String name,
                                     String description,
                                     Boolean legacy,
                                     Integer level,
                                     Set<String> effectCodes,
                                     Set<String> prerequisiteCodes) {
}
