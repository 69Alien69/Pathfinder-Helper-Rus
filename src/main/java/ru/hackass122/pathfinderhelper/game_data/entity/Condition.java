package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Condition extends RuleElement {

    @Column
    private String effect; // TODO: подумать над реализацией

    public Condition(String effect) {
        this.effect = effect;
    }

    protected Condition() {
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
