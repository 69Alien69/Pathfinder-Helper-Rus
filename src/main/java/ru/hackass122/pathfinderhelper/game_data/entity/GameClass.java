package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hackass122.pathfinderhelper.common.enums.*;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AssociationOverride(
        name = "traits",
        joinTable = @JoinTable(
                name = "game_class_traits",
                joinColumns = @JoinColumn(name = "game_class_id"),
                inverseJoinColumns = @JoinColumn(name = "traits_id")
        )
)
public class GameClass extends TaggableRuleElement{

    @Column
    private int hitDie;

    @ElementCollection(targetClass = Attribute.class)
    @CollectionTable(
            name = "key_ability",
            joinColumns = @JoinColumn(name = "class_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "boost", nullable = false)
    private Set<Attribute> keyAbilities = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column
    private ProficiencyRank initialPerception;

    @ElementCollection
    @CollectionTable(
            name = "class_save_proficiencies",
            joinColumns = @JoinColumn(name = "class_id")
    )
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "save_throw")
    @Column(name = "proficiency_rank")
    @Enumerated(EnumType.STRING)
    private Map<SaveThrow, ProficiencyRank> initialSaveThrowsProficiencies = new HashMap<>();

    @ElementCollection
    @CollectionTable(
            name = "class_skill_proficiencies",
            joinColumns = @JoinColumn(name = "class_id")
    )
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "skill")
    @Column(name = "proficiency_rank")
    @Enumerated(EnumType.STRING)
    private Map<Skill, ProficiencyRank> initialSkillProficiencies = new HashMap<>();

    @ElementCollection
    @CollectionTable(
            name = "class_weapon_proficiencies",
            joinColumns = @JoinColumn(name = "class_id")
    )
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "weapon")
    @Column(name = "proficiency_rank")
    @Enumerated(EnumType.STRING)
    private Map<WeaponCategory, ProficiencyRank> initialWeaponProficiencies = new HashMap<>();

    @ElementCollection
    @CollectionTable(
            name = "class_armor_proficiencies",
            joinColumns = @JoinColumn(name = "class_id")
    )
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "armor")
    @Column(name = "proficiency_rank")
    @Enumerated(EnumType.STRING)
    private Map<ArmorCategory, ProficiencyRank> initialArmorProficiencies = new HashMap<>();

    @ManyToMany
    @JoinTable(
            name = "class_feats",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "feat_id")
    )
    private Set<Feat> gameClassFeats = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "game_class_special_abilities",
            joinColumns = @JoinColumn(name = "game_class_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    private Set<SpecialAbility> specialAbilities = new HashSet<>();

    @Column
    private boolean isSpellCaster;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SpellCastingEntry> spellCastingEntries;

}
