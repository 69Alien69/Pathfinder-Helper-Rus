package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;

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
            name = "feat_effects",
            joinColumns = @JoinColumn(name = "feat_id"),
            inverseJoinColumns = @JoinColumn(name = "effect_id")
    )
    private Set<Effect> effects = new HashSet<>();

    @Column
    private String prerequisites; // TODO: заменить на подходящую реализацию



}
