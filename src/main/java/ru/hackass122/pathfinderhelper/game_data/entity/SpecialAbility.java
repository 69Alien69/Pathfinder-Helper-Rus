package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import ru.hackass122.pathfinderhelper.game_data.entity.items.Item;

@Entity
@AssociationOverride(
        name = "traits",
        joinTable = @JoinTable(
                name = "special_ability_traits",
                joinColumns = @JoinColumn(name = "special_ability_id"),
                inverseJoinColumns = @JoinColumn(name = "traits_id")
        )
)
public class SpecialAbility extends TaggableRuleElement {

    @Column
    private String abilityType; // TODO: заменить на enum после реализации

    @Column
    private String frequency; // TODO: заменить чем-то более подходящим

    @Column
    private int actionsRequired;

    @Column
    private String trigger; // TODO: подумать над заменой

    @Column
    private String prerequisites; // TODO: подумать над заменой

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column
    private int grantQuantity;

    public SpecialAbility(String abilityType, String frequency, int actionsRequired, String trigger,
                          String prerequisites, Item item, int grantQuantity) {
        this.abilityType = abilityType;
        this.frequency = frequency;
        this.actionsRequired = actionsRequired;
        this.trigger = trigger;
        this.prerequisites = prerequisites;
        this.item = item;
        this.grantQuantity = grantQuantity;
    }

    protected SpecialAbility() {
    }

    public String getAbilityType() {
        return abilityType;
    }

    public void setAbilityType(String abilityType) {
        this.abilityType = abilityType;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getActionsRequired() {
        return actionsRequired;
    }

    public void setActionsRequired(int actionsRequired) {
        this.actionsRequired = actionsRequired;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getGrantQuantity() {
        return grantQuantity;
    }

    public void setGrantQuantity(int grantQuantity) {
        this.grantQuantity = grantQuantity;
    }
}
