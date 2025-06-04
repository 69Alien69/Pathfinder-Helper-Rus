package ru.hackass122.pathfinderhelper.game_data.dto.request;

import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.Size;

import java.util.Set;

public record AncestryCreationRequestDto(String name,
                                         String description,
                                         Integer hitPoints,
                                         Size size,
                                         Integer speed,
                                         Set<Attribute> boosts,
                                         Set<Attribute> flaws,
                                         Set<Language> languages,
                                         Set<String> specialAbilitiesCodes,
                                         Set<String> heritagesCodes,
                                         Set<String> ancestryFeatsCodes,
                                         Set<String> traitsCodes,
                                         Boolean legacy) {
}
