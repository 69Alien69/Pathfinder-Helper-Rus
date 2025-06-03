package ru.hackass122.pathfinderhelper.character.model.value;

import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.ProficiencyRank;
import ru.hackass122.pathfinderhelper.game_data.entity.Bonus;

import java.util.List;


public class Modifier {

    private int value; // значение модификатора
    private Attribute attribute; // характеристика, от которой зависит модификатор
    private ProficiencyRank proficiency; // умение, от которого зависит модификатор
    private List<Bonus> bonuses; // бонусы, влияющие на модификатор

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public ProficiencyRank getProficiency() {
        return proficiency;
    }

    public void setProficiency(ProficiencyRank proficiency) {
        this.proficiency = proficiency;
    }

    public List<Bonus> getBonuses() {
        return bonuses;
    }

    public void setBonuses(List<Bonus> bonuses) {
        this.bonuses = bonuses;
    }
}
