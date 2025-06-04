package ru.hackass122.pathfinderhelper.game_data.service.impl;

import org.springframework.stereotype.Service;
import ru.hackass122.pathfinderhelper.game_data.entity.Feat;
import ru.hackass122.pathfinderhelper.game_data.repository.entity.FeatRepository;
import ru.hackass122.pathfinderhelper.game_data.service.FeatService;

import java.util.Set;

@Service
public class FeatServiceImpl implements FeatService {

    private final FeatRepository featRepository;

    public FeatServiceImpl(FeatRepository featRepository) {
        this.featRepository = featRepository;
    }


    @Override
    public Set<Feat> getFeatsByCodes(Set<String> codes) {
        return featRepository.findFeatByCodeIn(codes).orElseThrow();

    }
}
