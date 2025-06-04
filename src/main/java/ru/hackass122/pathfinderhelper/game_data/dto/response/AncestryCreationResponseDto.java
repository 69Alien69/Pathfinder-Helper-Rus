package ru.hackass122.pathfinderhelper.game_data.dto.response;

import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.Size;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;

import java.util.Set;

public record AncestryCreationResponseDto(Set<Size> sizes,
                                          Set<Attribute> attributes,
                                          Set<Language> languages,
                                          Set<SpecialAbilityResponseDto> specialAbilitiesResponseDtos,
                                          Set<TraitResponseDto> traitsResponseDtos) {
}
