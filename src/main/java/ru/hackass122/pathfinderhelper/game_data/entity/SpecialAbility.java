package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
