package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;

@Entity
public class Condition extends RuleElement {

    @Column
    private Effect effect; // TODO: подумать над реализацией

    public Condition(Effect effect) {
        this.effect = effect;
    }

    protected Condition() {
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
}
