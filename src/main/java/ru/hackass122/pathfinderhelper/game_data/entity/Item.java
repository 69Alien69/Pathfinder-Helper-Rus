package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AssociationOverride(
        name = "traits",
        joinTable = @JoinTable(
                name = "item_traits",
                joinColumns = @JoinColumn(name = "item_id"),
                inverseJoinColumns = @JoinColumn(name = "traits_id")
        )
)
public abstract class Item extends TaggableRuleElement {

    @Embedded
    private Currency price;

    @Embedded
    private Bulk bulk;

    @Column
    private boolean consumable;

    @Column
    private boolean magical;

    @Column
    private int level;
}
