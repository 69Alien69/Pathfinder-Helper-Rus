package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hackass122.pathfinderhelper.common.enums.ActionCost;
import ru.hackass122.pathfinderhelper.common.enums.MagicTradition;
import ru.hackass122.pathfinderhelper.common.enums.SaveThrow;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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




}
