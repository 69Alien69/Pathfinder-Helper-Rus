package ru.hackass122.pathfinderhelper.game_data.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.util.EffectMetadataProvider;
import ru.hackass122.pathfinderhelper.game_data.dto.response.EffectResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;
import ru.hackass122.pathfinderhelper.game_data.mapper.EffectDtoMapper;

import java.util.Map;

@Component
public class EffectDtoMapperImpl implements EffectDtoMapper {
    @Override
    public EffectResponseDto entityToResponseDto(Effect effect) {
        Map<String, Object> data = EffectMetadataProvider.getMetadataFor(effect.getType());

        return new EffectResponseDto(effect.getCode(),
                effect.getName(),
                effect.getDescription(),
                effect.isLegacy(),
                effect.getType(),
                data);
    }
}
