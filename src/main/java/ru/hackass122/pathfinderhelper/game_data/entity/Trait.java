package ru.hackass122.pathfinderhelper.game_data.entity;


import jakarta.persistence.Entity;
import ru.hackass122.pathfinderhelper.common.enums.TraitCategory;

@Entity
public class Trait extends RuleElement{

    private TraitCategory traitCategory;

    public Trait(String code, String name, String description, boolean legacy, Long id, TraitCategory traitCategory) {
        super(code, name, description, legacy, id);
        this.traitCategory = traitCategory;
    }

    public Trait() {
    }

    public TraitCategory getTraitCategory() {
        return traitCategory;
    }

    public void setTraitCategory(TraitCategory traitCategory) {
        this.traitCategory = traitCategory;
    }
}
