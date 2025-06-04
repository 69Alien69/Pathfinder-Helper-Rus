package ru.hackass122.pathfinderhelper.game_data.service;

import ru.hackass122.pathfinderhelper.game_data.entity.Feat;

import java.util.Set;

public interface FeatService {
    Set<Feat> getFeatsByCodes(Set<String> codes);
}
