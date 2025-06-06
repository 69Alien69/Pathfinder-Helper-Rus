package ru.hackass122.pathfinderhelper.game_data.dto.request;

import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.ProficiencyRank;
import ru.hackass122.pathfinderhelper.common.enums.Size;
import ru.hackass122.pathfinderhelper.common.enums.Skill;

import java.util.Map;
import java.util.Set;

public record HeritageCreationRequestDto(Set<String> traitCodes,
                                         String name,
                                         String description,
                                         Boolean legacy,
                                         Integer hitPointModifier,
                                         Size size,
                                         Set<Attribute> boosts,
                                         Set<Attribute> flaws,
                                         Set<String> specialAbilityCodes,
                                         Set<Language> languages,
                                         Map<Skill, ProficiencyRank> skillProficiencies,
                                         String resistances,
                                         Integer acBonus,
                                         Set<String> heritageFeatCodes) {
}
