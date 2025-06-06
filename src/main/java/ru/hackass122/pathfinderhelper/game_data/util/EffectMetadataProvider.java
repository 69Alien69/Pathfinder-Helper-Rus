package ru.hackass122.pathfinderhelper.game_data.util;

import ru.hackass122.pathfinderhelper.common.enums.EffectType;
import ru.hackass122.pathfinderhelper.common.enums.Skill;

import java.util.Map;

public class EffectMetadataProvider {

    public static Map<String, Object> getMetadataFor(EffectType type) {
        return switch (type) {
            case BONUS -> null;
            case LANGUAGE_GAIN -> null;
            case SENSE_GAIN -> null;
            case STRIKE_MODIFICATION -> null;
            case MOVEMENT_MODIFICATION -> null;
            case GRANT_ABILITY -> null;
            case CLASS_FEATURE_MODIFICATION -> null;
            case EQUIPMENT_ACCESS -> null;
            case REQUIREMENT_REMOVAL -> null;
            case SKILL_PROFICIENCY_INCREASE -> Map.of("skills", Skill.values());
            case SAVE_THROW_PROFICIENCY_INCREASE -> null;
            case PERCEPTION_PROFICIENCY_INCREASE -> null;
            case WEAPON_PROFICIENCY_INCREASE -> null;
            case ARMOR_PROFICIENCY_INCREASE -> null;
            case SPELL_PROFICIENCY_INCREASE -> null;
            case FEAT_UNLOCK -> null;
        };
    }
}
