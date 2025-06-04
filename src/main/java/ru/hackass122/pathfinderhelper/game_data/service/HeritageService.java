package ru.hackass122.pathfinderhelper.game_data.service;

import ru.hackass122.pathfinderhelper.game_data.entity.Heritage;

import java.util.Set;

public interface HeritageService {
    Set<Heritage> getHeritagesByCodes(Set<String> codes);
}
