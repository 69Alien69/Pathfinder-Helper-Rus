package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import ru.hackass122.pathfinderhelper.common.enums.ActionCost;
import ru.hackass122.pathfinderhelper.game_data.entity.prerequisite.Prerequisite;

import java.util.Set;

@Entity
public class Action extends RuleElement {

    @Enumerated(EnumType.STRING)
    @Column
    private ActionCost actionCost;

    @Column
    @ManyToMany
    private Set<Prerequisite> prerequisites;

    @Column
    private String trigger; // TODO: подумать над заменой

    public Action(ActionCost actionCost, Set<Prerequisite> prerequisites, String trigger) {
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

    public Set<Prerequisite> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(Set<Prerequisite> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }
}
