package ru.hackass122.pathfinderhelper.game_data.entity.spellcasting;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import ru.hackass122.pathfinderhelper.common.enums.ActionCost;
import ru.hackass122.pathfinderhelper.common.enums.MagicTradition;
import ru.hackass122.pathfinderhelper.common.enums.SaveThrow;
import ru.hackass122.pathfinderhelper.game_data.entity.TaggableRuleElement;

@Entity
@AssociationOverride(
        name = "traits",
        joinTable = @JoinTable(
                name = "spell_traits",
                joinColumns = @JoinColumn(name = "spell_id"),
                inverseJoinColumns = @JoinColumn(name = "traits_id")
        )
)
public class Spell extends TaggableRuleElement {

    @Enumerated(EnumType.STRING)
    @Column
    private MagicTradition magicTradition;

    @Column
    private boolean actionCast;

    @Enumerated(EnumType.STRING)
    @Column
    private ActionCost actionCastCost;

    @Column
    private int timeCast;

    @Column
    private int range;

    @Column
    private int area;

    @Column
    private String target; // TODO: подумать над заменой

    @Enumerated(EnumType.STRING)
    @Column
    private SaveThrow saveThrow;

    @Column
    private int duration;

    @Column
    private String effect; // TODO: подумать над реализацией

    public Spell(MagicTradition magicTradition, boolean actionCast, ActionCost actionCastCost, int timeCast, int range,
                 int area, String target, SaveThrow saveThrow, int duration, String effect) {
        this.magicTradition = magicTradition;
        this.actionCast = actionCast;
        this.actionCastCost = actionCastCost;
        this.timeCast = timeCast;
        this.range = range;
        this.area = area;
        this.target = target;
        this.saveThrow = saveThrow;
        this.duration = duration;
        this.effect = effect;
    }

    protected Spell() {
    }

    public MagicTradition getMagicTradition() {
        return magicTradition;
    }

    public void setMagicTradition(MagicTradition magicTradition) {
        this.magicTradition = magicTradition;
    }

    public boolean isActionCast() {
        return actionCast;
    }

    public void setActionCast(boolean actionCast) {
        this.actionCast = actionCast;
    }

    public ActionCost getActionCastCost() {
        return actionCastCost;
    }

    public void setActionCastCost(ActionCost actionCastCost) {
        this.actionCastCost = actionCastCost;
    }

    public int getTimeCast() {
        return timeCast;
    }

    public void setTimeCast(int timeCast) {
        this.timeCast = timeCast;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public SaveThrow getSaveThrow() {
        return saveThrow;
    }

    public void setSaveThrow(SaveThrow saveThrow) {
        this.saveThrow = saveThrow;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
