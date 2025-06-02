package ru.hackass122.pathfinderhelper.game_data.entity.effect;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.hackass122.pathfinderhelper.character.entity.PlayerCharacter;
import ru.hackass122.pathfinderhelper.common.enums.EffectType;

/**
 Описывает эффект применения бонуса к броскам
 */

@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Bonus")
public class BonusEffect extends Effect {

    /**
     Служебный метод, для определения типа эффекта при работе с абстрактными эффектами
     */
    @Override
    public EffectType getType() {
        return EffectType.BONUS;
    }

    @Override
    public void apply(PlayerCharacter character) {

    }
}
