package ru.hackass122.pathfinderhelper.game_data.dto.response;

import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.Size;

import java.util.Set;


public record AncestryResponseDto(String code,
                                  String name,
                                  String description,
                                  Integer hitPoints,
                                  Size size,
                                  Integer speed,
                                  Set<Attribute> boosts,
                                  Set<Attribute> flaws,
                                  Set<Language> languages,
                                  Set<SpecialAbilityResponseDto> specialAbilityResponseDtos,
                                  Set<HeritageResponseDto> heritageResponseDtos,
                                  Set<FeatResponseDto> ancestryFeatResponseDtos,
                                  Set<TraitResponseDto> traitResponseDtos,
                                  Boolean legacy) {
}
