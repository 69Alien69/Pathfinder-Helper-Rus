package ru.hackass122.pathfinderhelper.game_data.util;

import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.PrerequisiteType;

import java.util.Map;

public class PrerequisiteMetadataProvider {
    public static Map<String, Object> getMetadataFor(PrerequisiteType type) {
        return switch (type) {
            case ATTRIBUTE -> Map.of("Attributes", Attribute.values());
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
}
