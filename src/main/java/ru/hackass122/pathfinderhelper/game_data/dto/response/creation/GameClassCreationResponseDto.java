package ru.hackass122.pathfinderhelper.game_data.dto.response.creation;

import ru.hackass122.pathfinderhelper.common.enums.ArmorCategory;
import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.ProficiencyRank;
import ru.hackass122.pathfinderhelper.common.enums.SaveThrow;
import ru.hackass122.pathfinderhelper.common.enums.Skill;
import ru.hackass122.pathfinderhelper.common.enums.WeaponCategory;
import ru.hackass122.pathfinderhelper.game_data.dto.response.FeatResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpecialAbilityResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellCastingEntryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;

import java.util.Set;

public record GameClassCreationResponseDto(Set<TraitResponseDto> allTraits,
                                           Set<Attribute> allAbilities,
                                           Set<ProficiencyRank> allProficiencyRanks,
                                           Set<SaveThrow> allSaveThrows,
                                           Set<Skill> allSkills,
                                           Set<WeaponCategory> allWeaponCategories,
                                           Set<ArmorCategory> allArmorCategories,
                                           Set<FeatResponseDto> allGameClassFeats,
                                           Set<SpecialAbilityResponseDto> allSpecialAbilities,
                                           Set<SpellCastingEntryResponseDto> allSpellCastingEntries) {
}
