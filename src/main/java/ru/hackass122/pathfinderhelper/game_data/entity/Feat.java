package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AssociationOverride(
        name = "traits",
        joinTable = @JoinTable(
                name = "feat_traits",
                joinColumns = @JoinColumn(name = "feat_id"),
                inverseJoinColumns = @JoinColumn(name = "traits_id")
        )
)
public class Feat extends TaggableRuleElement {

    @Column
    private int level;

    @ManyToMany
    @JoinTable(
            name = "feat_actions",
            joinColumns = @JoinColumn(name = "feat_id"),
            inverseJoinColumns = @JoinColumn(name = "action_id")
    )
    private Set<Action> actions = new HashSet<>();

    @Column
    private String prerequisites; // TODO: заменить на подходящую реализацию



}
