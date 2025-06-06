package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.common.enums.EffectType;
import ru.hackass122.pathfinderhelper.game_data.util.EffectMetadataProvider;
import ru.hackass122.pathfinderhelper.game_data.dto.request.EffectCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.EffectResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.EffectCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;
import ru.hackass122.pathfinderhelper.game_data.util.EffectFactory;
import ru.hackass122.pathfinderhelper.game_data.mapper.EffectDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.EffectRepository;
import ru.hackass122.pathfinderhelper.game_data.service.EffectService;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
        return effectRepository.findAllByCodeIn(codes).orElseThrow();
    }

    @Override
    public EffectResponseDto getEffectResponseDtoByCode(String code) {
        Effect effect = getEffectByCode(code);
        return effectDtoMapper.entityToResponseDto(effect);
    }

    @Override
    public EffectCreationResponseDto getEffectCreationOptions() {
        Set<EffectType> types = EnumSet.allOf(EffectType.class);
        Map<EffectType, Map<String, Object>> dataPerType = new EnumMap<>(EffectType.class);
        for (EffectType type : EffectType.values()) {
            dataPerType.put(type, EffectMetadataProvider.getMetadataFor(type));
        }
        return new EffectCreationResponseDto(types, dataPerType);
    }

    @Override
    public EffectResponseDto createEffect(EffectCreationRequestDto effectCreationRequestDto) {
        Effect effect = EffectFactory.createEffectFrom(effectCreationRequestDto.name(),
                effectCreationRequestDto.description(),
                effectCreationRequestDto.legacy(),
                effectCreationRequestDto.effectType(),
                effectCreationRequestDto.data());
        return effectDtoMapper.entityToResponseDto(effect);
    }

    @Override
    public Effect getEffectByCode(String code) {
        return effectRepository.findEffectByCode(code).orElseThrow();
    }
}
