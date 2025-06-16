package ru.hackass122.pathfinderhelper.game_data.util;

import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.PrerequisiteType;
import ru.hackass122.pathfinderhelper.common.util.EntityCodeGenerator;
import ru.hackass122.pathfinderhelper.game_data.entity.prerequisite.AttributePrerequisite;
import ru.hackass122.pathfinderhelper.game_data.entity.prerequisite.Prerequisite;

import java.util.Map;

public class PrerequisiteFactory {
    private static final String TYPE = "Prerequisite";

    public static Prerequisite createPrerequisiteFrom(String name,
                                                      String description,
                                                      Boolean legacy,
                                                      PrerequisiteType type,
                                                      Map<String, Object> data) {
        return switch (type) {
            case ATTRIBUTE -> createAttributePrerequisite(name, description, legacy, data);
            case LEVEL -> null;
            case FEAT -> null;
            case PROFICIENCY -> null;
            case CLASS -> null;
            case ARCHETYPE -> null;
            case TRAIT -> null;
            case ANCESTRY -> null;
            case HERITAGE -> null;
            case CUSTOM -> null;
        };
    }

    private static Prerequisite createAttributePrerequisite(String name,
                                                            String description,
                                                            Boolean legacy,
                                                            Map<String, Object> data) {
        String code = EntityCodeGenerator.generateForOfficialComponent(name, TYPE, legacy);
        int requiredValue = (int) data.get("requiredValue");
        Attribute attribute = (Attribute) data.get("attribute");
        return new AttributePrerequisite(code, name, description, legacy, null, requiredValue, attribute);
    }
}
