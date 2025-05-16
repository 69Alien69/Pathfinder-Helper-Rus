package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.ProficiencyRank;
import ru.hackass122.pathfinderhelper.common.enums.Size;
import ru.hackass122.pathfinderhelper.common.enums.Skill;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AssociationOverride(
        name = "traits",
        joinTable = @JoinTable(
                name = "heritage_traits",
                joinColumns = @JoinColumn(name = "heritage_id"),
                inverseJoinColumns = @JoinColumn(name = "traits_id")
        )
)
public class Heritage extends TaggableRuleElement {

    @Column
    private int hitPointModifier;

    @Column
    @Enumerated(EnumType.STRING)
    private Size size;

    @Embedded
    @AssociationOverrides({
            @AssociationOverride(
                    name = "attributeModifiers.boosts",
                    joinTable = @JoinTable(
                            name = "heritage_boosts",
                            joinColumns = @JoinColumn(name = "heritage_id")
                    )
            ),
            @AssociationOverride(
                    name = "attributeModifiers.flaws",
                    joinTable = @JoinTable(
                            name = "heritage_flaws",
                            joinColumns = @JoinColumn(name = "heritage_id")
                    )
            )
    })
    private AttributeModifiers attributeModifiers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "heritage_special_abilities",
            joinColumns = @JoinColumn(name = "heritage_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    private Set<SpecialAbility> specialAbilities = new HashSet<>();

    @ElementCollection(targetClass = Language.class, fetch = FetchType.LAZY)
    @CollectionTable(
            name = "heritage_languages",
            joinColumns = @JoinColumn(name = "heritage_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "language", nullable = false)
    private Set<Language> languages = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name = "heritage_skill_ranks",
            joinColumns = @JoinColumn(name = "heritage_id")
    )
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "skill")
    @Column(name = "rank", nullable = false)
    @Enumerated(EnumType.STRING)
    private Map<Skill, ProficiencyRank> skillProficiencies = new HashMap<>();

    @Column
    private String resistances; // TODO: поменять когда будет реализация сопротивления

    @Column
    private int acBonus;

    @ManyToMany
    @JoinTable(
            name = "heritage_feats",
            joinColumns = @JoinColumn(name = "heritage_id"),
            inverseJoinColumns = @JoinColumn(name = "feat_id")
    )
    private Set<Feat> heritageFeats = new HashSet<>();

}
