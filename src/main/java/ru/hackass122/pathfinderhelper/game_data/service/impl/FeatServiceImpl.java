package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.common.util.EntityCodeGenerator;
import ru.hackass122.pathfinderhelper.game_data.dto.request.FeatCreationRequestDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.EffectResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.creation.FeatCreationResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.FeatResponseDto;
import ru.hackass122.pathfinderhelper.game_data.dto.response.TraitResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Feat;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;
import ru.hackass122.pathfinderhelper.game_data.mapper.FeatDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.FeatRepository;
import ru.hackass122.pathfinderhelper.game_data.service.EffectService;
import ru.hackass122.pathfinderhelper.game_data.service.FeatService;
import ru.hackass122.pathfinderhelper.game_data.service.TraitService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class FeatServiceImpl implements FeatService {

    private final FeatRepository featRepository;
    private final FeatDtoMapper featDtoMapper;
    private final TraitService traitService;
    private final EffectService effectService;

    private static final String TYPE = "Feat";

    public FeatServiceImpl(FeatRepository featRepository, FeatDtoMapper featDtoMapper, TraitService traitService, EffectService effectService) {
        this.featRepository = featRepository;
        this.featDtoMapper = featDtoMapper;
        this.traitService = traitService;
        this.effectService = effectService;
    }


    @Override
    public Set<Feat> getFeatsByCodes(Set<String> codes) {
        return featRepository.findFeatByCodeIn(codes).orElseThrow();

    }

    @Override
    public List<FeatResponseDto> getAllFeatResponseDtos() {
        List<Feat> feats = featRepository.findAll();
        List<FeatResponseDto> featResponseDtos = new ArrayList<>(feats.size());
        for (Feat feat : feats) {
            featResponseDtos.add(featDtoMapper.entityToResponseDto(feat));
        }
        return featResponseDtos;
    }

    @Override
    public FeatResponseDto getFeatResponseDtoByCode(String code) {
        Feat feat = featRepository.findFeatByCode(code).orElseThrow();
        return featDtoMapper.entityToResponseDto(feat);
    }

    @Override
    public FeatCreationResponseDto getFeatCreationOptions() {
        Set<TraitResponseDto> traitResponseDtos = traitService.getAllTraitResponseDtos();
        Set<EffectResponseDto> effectResponseDtos = effectService.getAllEffectResponseDtos();

        return new FeatCreationResponseDto(traitResponseDtos,
                effectResponseDtos,
                "prerequisitesMock");
    }

    @Override
    public FeatResponseDto createFeat(FeatCreationRequestDto featCreationRequestDto) {
        Set<Trait> traits = traitService.getTraitByCodes(featCreationRequestDto.traitCodes());
        Set<Effect> effects = effectService.getEffectsByCodes(featCreationRequestDto.effectCodes());

        String code = EntityCodeGenerator.generateForOfficialComponent(featCreationRequestDto.name(),
                TYPE,
                featCreationRequestDto.legacy());

        Feat feat = new Feat(traits,
                code,
                featCreationRequestDto.name(),
                featCreationRequestDto.description(),
                featCreationRequestDto.legacy(),
                null,
                featCreationRequestDto.level(),
                effects,
                featCreationRequestDto.prerequisites());

        feat = featRepository.save(feat);
        return featDtoMapper.entityToResponseDto(feat);
    }
}
