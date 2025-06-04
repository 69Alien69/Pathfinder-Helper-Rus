package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.game_data.entity.Heritage;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.HeritageRepository;
import ru.hackass122.pathfinderhelper.game_data.service.HeritageService;

import java.util.Set;

@Service
public class HeritageServiceImpl implements HeritageService {

    private final HeritageRepository heritageRepository;

    public HeritageServiceImpl(HeritageRepository heritageRepository) {
        this.heritageRepository = heritageRepository;
    }

    @Override
    public Set<Heritage> getHeritagesByCodes(Set<String> codes) {
        return heritageRepository.findHeritageByCodeIn(codes).orElseThrow();
    }
}
