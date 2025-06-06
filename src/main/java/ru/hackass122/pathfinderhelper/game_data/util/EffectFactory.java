package ru.hackass122.pathfinderhelper.game_data.util;


import ru.hackass122.pathfinderhelper.common.enums.EffectType;
import ru.hackass122.pathfinderhelper.common.enums.Skill;
import ru.hackass122.pathfinderhelper.common.util.EntityCodeGenerator;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.SkillProficiencyIncreaseEffect;

import java.util.Map;

public class EffectFactory {

    private static final String TYPE = "EFFECT";

    public static Effect createEffectFrom(String name, String description, Boolean legacy, EffectType effectType,
                                          Map<String, Object> data) {
        return switch (effectType) {
            case BONUS -> null;
            case LANGUAGE_GAIN -> null;
            case SENSE_GAIN -> null;
            case STRIKE_MODIFICATION -> null;
            case MOVEMENT_MODIFICATION -> null;
            case GRANT_ABILITY -> null;
            case CLASS_FEATURE_MODIFICATION -> null;
            case EQUIPMENT_ACCESS -> null;
            case REQUIREMENT_REMOVAL -> null;
            case SKILL_PROFICIENCY_INCREASE ->
                    createSkillProficiencyIncrease(name, description, legacy, effectType, data);
            case SAVE_THROW_PROFICIENCY_INCREASE -> null;
            case PERCEPTION_PROFICIENCY_INCREASE -> null;
            case WEAPON_PROFICIENCY_INCREASE -> null;
            case ARMOR_PROFICIENCY_INCREASE -> null;
            case SPELL_PROFICIENCY_INCREASE -> null;
            case FEAT_UNLOCK -> null;
        };
    }

    private static Effect createSkillProficiencyIncrease(String name, String description, Boolean legacy, EffectType effectType,
                                                         Map<String, Object> data) {
        String code = EntityCodeGenerator.generateForOfficialComponent(name, TYPE, legacy);
        return new SkillProficiencyIncreaseEffect(code,
                name,
                description,
                legacy,
                null,
                (Skill) data.get("targetSkill"));
    }
}
