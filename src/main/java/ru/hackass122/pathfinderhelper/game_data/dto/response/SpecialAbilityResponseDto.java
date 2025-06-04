package ru.hackass122.pathfinderhelper.game_data.dto.response;

public record SpecialAbilityResponseDto(String code,
                                        String name,
                                        String description,
                                        boolean legacy,
                                        EffectResponseDto effect) {
}
