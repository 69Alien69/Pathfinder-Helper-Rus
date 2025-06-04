package ru.hackass122.pathfinderhelper.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EntityCodeGenerator {

    private static String slugify(String name, String type) {
        String raw = String.format("%s_%s", name, type);
        return raw.trim().toLowerCase()
                .replaceAll("[^a-z0-9]+", "_")
                .replaceAll("^_+|_+$", "");
    }

    public static String generateForOfficialComponent (String name, String type) {
        return slugify(name, type);
    }

    public static String generateForCustomComponent(String name, String type, String username, LocalDateTime creationTime) {
        String base = slugify(name, type);
        String timePart = creationTime.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmm"));
        return String.format("%s_%s_%s", base, username.toLowerCase(), timePart);
    }
}
