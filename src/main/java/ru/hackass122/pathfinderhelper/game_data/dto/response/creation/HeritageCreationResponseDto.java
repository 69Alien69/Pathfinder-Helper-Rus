package ru.hackass122.pathfinderhelper.game_data.dto.response.creation;

import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.ProficiencyRank;
import ru.hackass122.pathfinderhelper.common.enums.Size;
import ru.hackass122.pathfinderhelper.common.enums.Skill;
import ru.hackass122.pathfinderhelper.game_data.dto.response.FeatResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;

import java.util.Set;

public record HeritageCreationResponseDto(Set<TraitResponseDto> traitResponseDtos,
                                          Set<Size> sizes,
                                          Set<Attribute> attributes,
                                          Set<SpecialAbilityResponseDto> specialAbilityResponseDtos,
                                          Set<Language> languages,
                                          Set<Skill> skills,
                                          Set<ProficiencyRank> proficiencyRanks,
                                          String resistances,
                                          Set<FeatResponseDto> heritageFeatResponseDtos) {
}
