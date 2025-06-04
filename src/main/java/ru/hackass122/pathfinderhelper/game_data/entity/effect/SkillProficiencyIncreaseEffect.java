package ru.hackass122.pathfinderhelper.game_data.entity.effect;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import ru.hackass122.pathfinderhelper.character.model.entity.PlayerCharacter;
import ru.hackass122.pathfinderhelper.common.enums.EffectType;
import ru.hackass122.pathfinderhelper.common.enums.ProficiencyRank;
import ru.hackass122.pathfinderhelper.common.enums.Skill;

import java.util.Map;
import java.util.Optional;

/**
Описывает эффект повышения навыка персонажа
 */
@Entity
@DiscriminatorValue("SkillIncrease")
public class SkillProficiencyIncreaseEffect extends Effect {

    @Column
    @Enumerated(EnumType.STRING)
    private Skill targetSkill;

    public SkillProficiencyIncreaseEffect(String code, String name, String description, boolean legacy, Long id,
                                          Skill targetSkill) {
        super(code, name, description, legacy, id);
        this.targetSkill = targetSkill;
    }

    protected SkillProficiencyIncreaseEffect() {
    }

    /**
     Служебный метод, для определения типа эффекта при работе с абстрактными эффектами
     */
    @Override
    public EffectType getType() {
        return EffectType.SKILL_PROFICIENCY_INCREASE;
    }

    /**
     Метод применяет эффект к персонажу.
     Принимает объект PlayerCharacter и повышает уровень навыка targetSkill

     @param character персонаж, к которому применяется эффект
     */
    @Override
    public void apply(PlayerCharacter character) {
        Map<Skill, ProficiencyRank> skillProficiencyRankMap = character.getSkills();
        Optional<ProficiencyRank> next = skillProficiencyRankMap.get(targetSkill).next();
        skillProficiencyRankMap.put(targetSkill, next.orElseThrow(IllegalStateException::new)); // TODO реализовать специальный exception и заменить
        character.setSkills(skillProficiencyRankMap);
    }

    public Skill getTargetSkill() {
        return targetSkill;
    }

    public void setTargetSkill(Skill targetSkill) {
        this.targetSkill = targetSkill;
    }
}
