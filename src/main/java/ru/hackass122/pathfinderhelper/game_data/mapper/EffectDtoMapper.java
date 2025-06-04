package ru.hackass122.pathfinderhelper.game_data.mapper;

import ru.hackass122.pathfinderhelper.game_data.dto.response.EffectResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;

public interface EffectDtoMapper {
    EffectResponseDto entityToResponseDto(Effect effect);
}
