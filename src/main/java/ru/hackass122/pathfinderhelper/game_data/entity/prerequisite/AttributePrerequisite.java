package ru.hackass122.pathfinderhelper.game_data.entity.prerequisite;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import ru.hackass122.pathfinderhelper.character.model.entity.Attributes;
import ru.hackass122.pathfinderhelper.character.model.entity.PlayerCharacter;
import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.PrerequisiteType;

@Entity
@DiscriminatorValue("Attribute")
public class AttributePrerequisite  extends Prerequisite {

    private int requiredValue;
    private Attribute attribute;

    public AttributePrerequisite(String code, String name, String description, boolean legacy, Long id,
                                 int requiredValue, Attribute attribute) {
        super(code, name, description, legacy, id);
        this.requiredValue = requiredValue;
        this.attribute = attribute;
    }

    public AttributePrerequisite() {
    }

    @Override
    public PrerequisiteType getType() {
        return PrerequisiteType.ATTRIBUTE;
    }

    @Override
    public boolean isMatching(PlayerCharacter character) {
        Attributes attributes = character.getAttributes();
        switch (attribute) {
            case STRENGTH -> {return attributes.getStrength() >= requiredValue;}
            case DEXTERITY -> {return attributes.getDexterity() >= requiredValue;}
            case CONSTITUTION -> {return attributes.getConstitution() >= requiredValue;}
            case INTELLIGENCE -> {return attributes.getIntelligence() >= requiredValue;}
            case WISDOM -> {return attributes.getWisdom() >= requiredValue;}
            case CHARISMA -> {return attributes.getCharisma() >= requiredValue;}
        }
        return false;
    }
}
