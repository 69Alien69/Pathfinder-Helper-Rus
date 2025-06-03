package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import ru.hackass122.pathfinderhelper.common.enums.ActionCost;

@Entity
public class Action extends RuleElement {

    @Enumerated(EnumType.STRING)
    @Column
    private ActionCost actionCost;

    @Column
    private String prerequisites; // TODO: подумать над заменой

    @Column
    private String trigger; // TODO: подумать над заменой

    public Action(ActionCost actionCost, String prerequisites, String trigger) {
        this.actionCost = actionCost;
        this.prerequisites = prerequisites;
        this.trigger = trigger;
    }

    protected Action() {
    }

    public ActionCost getActionCost() {
        return actionCost;
    }

    public void setActionCost(ActionCost actionCost) {
        this.actionCost = actionCost;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }
}
