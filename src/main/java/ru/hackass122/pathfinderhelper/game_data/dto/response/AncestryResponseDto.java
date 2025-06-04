package ru.hackass122.pathfinderhelper.game_data.dto.response;

import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.Size;
import ru.hackass122.pathfinderhelper.game_data.entity.Feat;
import ru.hackass122.pathfinderhelper.game_data.entity.Heritage;
import ru.hackass122.pathfinderhelper.game_data.entity.SpecialAbility;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;

import java.util.Set;


public record AncestryResponseDto(Long id,
                                  String code,
                                  String name,
                                  String description,
                                  Integer hitPoints,
                                  Size size,
                                  Integer speed,
                                  Set<Attribute> boosts,
                                  Set<Attribute> flaws,
                                  Set<Language> languages,
                                  Set<SpecialAbility> specialAbilities,
                                  Set<Heritage> heritages,
                                  Set<Feat> ancestryFeats,
                                  Set<Trait> traits,
                                  Boolean deprecated) { // TODO: заменить сущности на DTO
}
