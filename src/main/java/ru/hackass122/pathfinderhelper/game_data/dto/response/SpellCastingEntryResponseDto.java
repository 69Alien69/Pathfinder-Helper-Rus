package ru.hackass122.pathfinderhelper.game_data.dto.response;

import ru.hackass122.pathfinderhelper.common.enums.MagicTradition;

import java.util.List;
import java.util.Set;

public record SpellCastingEntryResponseDto(MagicTradition magicTradition,
                                           Boolean hasSpells,
                                           List<SpellSlotsResponseDto> slots,
                                           Set<SpellKnownResponseDto> knownSpells) {
}
