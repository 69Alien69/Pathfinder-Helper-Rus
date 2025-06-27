package ru.hackass122.pathfinderhelper.game_data.dto.request;

import ru.hackass122.pathfinderhelper.common.enums.ArmorCategory;
import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.ProficiencyRank;
import ru.hackass122.pathfinderhelper.common.enums.SaveThrow;
import ru.hackass122.pathfinderhelper.common.enums.Skill;
import ru.hackass122.pathfinderhelper.common.enums.WeaponCategory;

import java.util.Map;
import java.util.Set;

public record GameClassCreationRequestDto(Set<String> traitCodes,
                                          String name,
                                          String description,
                                          Boolean legacy,
                                          Integer hitDie,
                                          Set<Attribute> keyAbilities,
                                          ProficiencyRank initialPerception,
                                          Map<SaveThrow, ProficiencyRank> initialSaveThrowsProficiencies,
                                          Map<Skill, ProficiencyRank> initialSkillProficiencies,
                                          Map<WeaponCategory, ProficiencyRank> initialWeaponProficiencies,
                                          Map<ArmorCategory, ProficiencyRank> initialArmorProficiencies,
                                          Set<String> gameClassFeatCodes,
                                          Set<String> specialAbilityCodes,
                                          Boolean isSpellCaster,
                                          Set<Long> spellCastingEntryIds) {
}
