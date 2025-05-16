package ru.hackass122.pathfinderhelper.common.contract;

import ru.hackass122.pathfinderhelper.game_data.entity.Trait;

import java.util.Set;

public interface Taggable {
    Set<Trait> getTraits();
    void setTraits(Set<Trait> traits);
}
