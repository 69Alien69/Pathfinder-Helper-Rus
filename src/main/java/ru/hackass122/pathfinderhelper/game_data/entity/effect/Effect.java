package ru.hackass122.pathfinderhelper.game_data.entity.effect;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hackass122.pathfinderhelper.character.entity.PlayerCharacter;
import ru.hackass122.pathfinderhelper.common.enums.EffectType;
import ru.hackass122.pathfinderhelper.game_data.entity.RuleElement;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "effect_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Effect extends RuleElement {

    public abstract EffectType getType();

    public abstract void apply(PlayerCharacter character);



}
