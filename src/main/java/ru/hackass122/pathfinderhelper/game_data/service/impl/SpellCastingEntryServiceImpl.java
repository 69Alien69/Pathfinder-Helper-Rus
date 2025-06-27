package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.game_data.dto.response.SpellCastingEntryResponseDto;
import ru.hackass122.pathfinderhelper.game_data.entity.spellcasting.SpellCastingEntry;
import ru.hackass122.pathfinderhelper.game_data.mapper.SpellCastingEntryDtoMapper;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.SpellCastingEntryRepository;
import ru.hackass122.pathfinderhelper.game_data.service.SpellCastingEntryService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SpellCastingEntryServiceImpl implements SpellCastingEntryService {

    private final SpellCastingEntryRepository spellCastingEntryRepository;
    private final SpellCastingEntryDtoMapper spellCastingEntryDtoMapper;


    public SpellCastingEntryServiceImpl(SpellCastingEntryRepository spellCastingEntryRepository, SpellCastingEntryDtoMapper spellCastingEntryDtoMapper) {
        this.spellCastingEntryRepository = spellCastingEntryRepository;
        this.spellCastingEntryDtoMapper = spellCastingEntryDtoMapper;
    }

    @Override
    public Set<SpellCastingEntry> getSpellCastingEntriesByIds(Set<Long> spellCastingEntryIds) {
        List<SpellCastingEntry> spellCastingEntries = spellCastingEntryRepository.findAllById(spellCastingEntryIds);
        return new HashSet<>(spellCastingEntries);
    }

    @Override
    public Set<SpellCastingEntryResponseDto> getAllSpellCastingEntriesResponseDtos() {
        List<SpellCastingEntry> spellCastingEntries = spellCastingEntryRepository.findAll();
        Set<SpellCastingEntryResponseDto> spellCastingEntryResponseDtos = new HashSet<>();
        for(SpellCastingEntry spellCastingEntry : spellCastingEntries) {
            spellCastingEntryResponseDtos.add(spellCastingEntryDtoMapper.entityToResponseDto(spellCastingEntry));
        }
        return spellCastingEntryResponseDtos;
    }
}
