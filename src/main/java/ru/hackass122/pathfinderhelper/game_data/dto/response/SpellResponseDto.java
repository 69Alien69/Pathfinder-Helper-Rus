package ru.hackass122.pathfinderhelper.game_data.dto.response;

import ru.hackass122.pathfinderhelper.common.enums.ActionCost;
import ru.hackass122.pathfinderhelper.common.enums.MagicTradition;
import ru.hackass122.pathfinderhelper.common.enums.SaveThrow;

import java.util.Set;

public record SpellResponseDto(Set<TraitResponseDto> traits,
                               String code,
                               String name,
                               String description,
                               Boolean legacy,
                               MagicTradition magicTradition,
                               Boolean actionCast,
                               ActionCost actionCastCost,
                               Integer timeCast,
                               Integer range,
                               Integer area,
                               String target,
                               SaveThrow saveThrow,
                               Integer duration,
                               String effect) {
}
