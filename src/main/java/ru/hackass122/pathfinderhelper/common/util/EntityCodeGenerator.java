package ru.hackass122.pathfinderhelper.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EntityCodeGenerator {

    private static String slugify(String name) {
        return name.trim().toLowerCase()
                .replaceAll("[^a-z0-9]+", "_")
                .replaceAll("^_+|_+$", "");
    }

    public static String generateForOfficialComponent (String name) {
        return slugify(name);
    }

    public static String custom(String name, String username, LocalDateTime creationTime) {
        String base = slugify(name);
        String timePart = creationTime.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmm"));
        return String.format("%s_%s_%s", base, username.toLowerCase(), timePart);
    }
}
