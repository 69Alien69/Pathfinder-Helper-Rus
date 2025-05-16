package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.Size;

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
                name = "ancestry_traits",
                joinColumns = @JoinColumn(name = "ancestry_id"),
                inverseJoinColumns = @JoinColumn(name = "traits_id")
        )
)
public class Ancestry extends TaggableRuleElement {

    @Column
    private int hitPoints;

    @Enumerated(EnumType.STRING)
    @Column
    private Size size;

    @Column
    private int speed;

    @Embedded
    @AssociationOverrides({
            @AssociationOverride(
                    name = "attributeModifiers.boosts",
                    joinTable = @JoinTable(
                            name = "ancestry_boosts",
                            joinColumns = @JoinColumn(name = "ancestry_id")
                    )
            ),
            @AssociationOverride(
                    name = "attributeModifiers.flaws",
                    joinTable = @JoinTable(
                            name = "ancestry_flaws",
                            joinColumns = @JoinColumn(name = "ancestry_id")
                    )
            )
    })
    private AttributeModifiers attributeModifiers;

    @ElementCollection(targetClass = Language.class, fetch = FetchType.LAZY)
    @CollectionTable(
            name = "ancestry_languages",
            joinColumns = @JoinColumn(name = "ancestry_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "language", nullable = false)
    private Set<Language> languages = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ancestry_special_abilities",
            joinColumns = @JoinColumn(name = "ancestry_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    private Set<SpecialAbility> specialAbilities = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ancestry_heritages",
            joinColumns = @JoinColumn(name = "ancestry_id"),
            inverseJoinColumns = @JoinColumn(name = "heritage_id")
    )
    private Set<Heritage> heritages = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "ancestry_feats",
            joinColumns = @JoinColumn(name = "ancestry_id"),
            inverseJoinColumns = @JoinColumn(name = "feat_id")
    )
    private Set<Feat> ancestryFeats = new HashSet<>();


}
