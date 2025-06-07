package ru.hackass122.pathfinderhelper.game_data.entity.prerequisite;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import ru.hackass122.pathfinderhelper.character.model.entity.PlayerCharacter;
import ru.hackass122.pathfinderhelper.common.enums.PrerequisiteType;
import ru.hackass122.pathfinderhelper.game_data.entity.RuleElement;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "prerequisite_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Prerequisite extends RuleElement {

    public Prerequisite(String code, String name, String description, boolean legacy, Long id) {
        super(code, name, description, legacy, id);
    }

    public Prerequisite() {
    }

    public abstract PrerequisiteType getType();

    public abstract boolean isMatching(PlayerCharacter character);

}
