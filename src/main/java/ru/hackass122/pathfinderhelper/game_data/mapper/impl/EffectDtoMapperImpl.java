package ru.hackass122.pathfinderhelper.game_data.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hackass122.pathfinderhelper.game_data.dto.response.EffectResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.SkillProficiencyIncreaseEffect;
import ru.hackass122.pathfinderhelper.game_data.mapper.EffectDtoMapper;

import java.util.HashMap;
import java.util.Map;

@Component
public class EffectDtoMapperImpl implements EffectDtoMapper {
    @Override
    public EffectResponseDto entityToResponseDto(Effect effect) {
        Map<String, Object> data = new HashMap<>();

        switch (effect.getType()){
            case SKILL_PROFICIENCY_INCREASE -> {
                SkillProficiencyIncreaseEffect e = (SkillProficiencyIncreaseEffect) effect;
                data.put("targetSkill", e.getTargetSkill().name());
            } // TODO: реализовать кейсы для всех случаев после реализации соответствующих эффектов
        }

        return new EffectResponseDto(effect.getCode(),
                effect.getName(),
                effect.getDescription(),
                effect.isLegacy(),
                effect.getType(),
                data);
    }
}
