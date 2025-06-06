package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.game_data.dto.response.EffectResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;
import ru.hackass122.pathfinderhelper.game_data.mapper.EffectDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.EffectRepository;
import ru.hackass122.pathfinderhelper.game_data.service.EffectService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EffectServiceImpl implements EffectService {

    private final EffectRepository effectRepository;
    private final EffectDtoMapper effectDtoMapper;

    public EffectServiceImpl(EffectRepository effectRepository, EffectDtoMapper effectDtoMapper) {
        this.effectRepository = effectRepository;
        this.effectDtoMapper = effectDtoMapper;
    }

    @Override
    public Set<EffectResponseDto> getAllEffectResponseDtos() {
        List<Effect> effects = effectRepository.findAll();
        Set<EffectResponseDto> effectResponseDtos = new HashSet<>();
        for (Effect effect : effects) {
            effectResponseDtos.add(effectDtoMapper.entityToResponseDto(effect));
        }
        return effectResponseDtos;
    }

    @Override
    public Set<Effect> getEffectsByCodes(Set<String> codes) {
        return effectRepository.findAllByCodeIn(codes);
    }
}
