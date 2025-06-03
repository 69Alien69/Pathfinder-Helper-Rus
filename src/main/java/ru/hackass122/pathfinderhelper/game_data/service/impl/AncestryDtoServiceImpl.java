package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.game_data.dto.response.AncestryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.Ancestry;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.AncestryRepository;
import ru.hackass122.pathfinderhelper.game_data.service.AncestryDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.service.AncestryDtoService;

import java.util.Optional;

@Service
public class AncestryDtoServiceImpl implements AncestryDtoService {

    private final AncestryDtoMapper ancestryDtoMapper;
    private final AncestryRepository ancestryRepository;

    public AncestryDtoServiceImpl(AncestryDtoMapper ancestryDtoMapper, AncestryRepository ancestryRepository) {
        this.ancestryDtoMapper = ancestryDtoMapper;
        this.ancestryRepository = ancestryRepository;
    }

    @Override
    public AncestryResponseDto getAncestryDtoByCode(String code) {
        Ancestry ancestry = ancestryRepository.getAncestryByCode(code).orElseThrow();
        return ancestryDtoMapper.ancestryToResponseDto(ancestry);
    }
}
