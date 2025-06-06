package ru.hackass122.pathfinderhelper.game_data.dto.request;


public record SpecialAbilityCreationRequestDto(String name,
                                               String description,
                                               Boolean legacy,
                                               String effectCode) {
}
