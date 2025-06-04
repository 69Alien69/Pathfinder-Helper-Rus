package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;

@Entity
public class SpecialAbility extends RuleElement {

    @ManyToOne
    private Effect effect;

    public SpecialAbility(String code, String name, String description, boolean legacy, Long id,
                          Effect effect) {
        super(code, name, description, legacy, id);
        this.effect = effect;
    }

    protected SpecialAbility() {
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
}
