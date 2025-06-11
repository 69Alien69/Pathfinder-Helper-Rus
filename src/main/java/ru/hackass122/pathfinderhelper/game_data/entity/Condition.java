package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;

@Entity
public class Condition extends RuleElement {

    @OneToOne
    private Effect effect;

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
