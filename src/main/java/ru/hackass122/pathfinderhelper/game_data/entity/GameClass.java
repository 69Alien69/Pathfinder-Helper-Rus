package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.OneToMany;
import ru.hackass122.pathfinderhelper.common.enums.ArmorCategory;
import ru.hackass122.pathfinderhelper.common.enums.Attribute;
import ru.hackass122.pathfinderhelper.common.enums.ProficiencyRank;
import ru.hackass122.pathfinderhelper.common.enums.SaveThrow;
import ru.hackass122.pathfinderhelper.common.enums.Skill;
import ru.hackass122.pathfinderhelper.common.enums.WeaponCategory;
import ru.hackass122.pathfinderhelper.game_data.entity.spellcasting.SpellCastingEntry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
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

    public GameClass(Set<Trait> traits, String code, String name, String description, boolean legacy, Long id,
                     int hitDie, Set<Attribute> keyAbilities, ProficiencyRank initialPerception,
                     Map<SaveThrow, ProficiencyRank> initialSaveThrowsProficiencies,
                     Map<Skill, ProficiencyRank> initialSkillProficiencies,
                     Map<WeaponCategory, ProficiencyRank> initialWeaponProficiencies,
                     Map<ArmorCategory, ProficiencyRank> initialArmorProficiencies, Set<Feat> gameClassFeats,
                     Set<SpecialAbility> specialAbilities, boolean isSpellCaster,
                     Set<SpellCastingEntry> spellCastingEntries) {
        super(traits, code, name, description, legacy, id);
        this.hitDie = hitDie;
        this.keyAbilities = keyAbilities;
        this.initialPerception = initialPerception;
        this.initialSaveThrowsProficiencies = initialSaveThrowsProficiencies;
        this.initialSkillProficiencies = initialSkillProficiencies;
        this.initialWeaponProficiencies = initialWeaponProficiencies;
        this.initialArmorProficiencies = initialArmorProficiencies;
        this.gameClassFeats = gameClassFeats;
        this.specialAbilities = specialAbilities;
        this.isSpellCaster = isSpellCaster;
        this.spellCastingEntries = spellCastingEntries;
    }

    protected GameClass() {
    }

    public int getHitDie() {
        return hitDie;
    }

    public void setHitDie(int hitDie) {
        this.hitDie = hitDie;
    }

    public Set<Attribute> getKeyAbilities() {
        return keyAbilities;
    }

    public void setKeyAbilities(Set<Attribute> keyAbilities) {
        this.keyAbilities = keyAbilities;
    }

    public ProficiencyRank getInitialPerception() {
        return initialPerception;
    }

    public void setInitialPerception(ProficiencyRank initialPerception) {
        this.initialPerception = initialPerception;
    }

    public Map<SaveThrow, ProficiencyRank> getInitialSaveThrowsProficiencies() {
        return initialSaveThrowsProficiencies;
    }

    public void setInitialSaveThrowsProficiencies(Map<SaveThrow, ProficiencyRank> initialSaveThrowsProficiencies) {
        this.initialSaveThrowsProficiencies = initialSaveThrowsProficiencies;
    }

    public Map<Skill, ProficiencyRank> getInitialSkillProficiencies() {
        return initialSkillProficiencies;
    }

    public void setInitialSkillProficiencies(Map<Skill, ProficiencyRank> initialSkillProficiencies) {
        this.initialSkillProficiencies = initialSkillProficiencies;
    }

    public Map<WeaponCategory, ProficiencyRank> getInitialWeaponProficiencies() {
        return initialWeaponProficiencies;
    }

    public void setInitialWeaponProficiencies(Map<WeaponCategory, ProficiencyRank> initialWeaponProficiencies) {
        this.initialWeaponProficiencies = initialWeaponProficiencies;
    }

    public Map<ArmorCategory, ProficiencyRank> getInitialArmorProficiencies() {
        return initialArmorProficiencies;
    }

    public void setInitialArmorProficiencies(Map<ArmorCategory, ProficiencyRank> initialArmorProficiencies) {
        this.initialArmorProficiencies = initialArmorProficiencies;
    }

    public Set<Feat> getGameClassFeats() {
        return gameClassFeats;
    }

    public void setGameClassFeats(Set<Feat> gameClassFeats) {
        this.gameClassFeats = gameClassFeats;
    }

    public Set<SpecialAbility> getSpecialAbilities() {
        return specialAbilities;
    }

    public void setSpecialAbilities(Set<SpecialAbility> specialAbilities) {
        this.specialAbilities = specialAbilities;
    }

    public boolean isSpellCaster() {
        return isSpellCaster;
    }

    public void setSpellCaster(boolean spellCaster) {
        isSpellCaster = spellCaster;
    }

    public Set<SpellCastingEntry> getSpellCastingEntries() {
        return spellCastingEntries;
    }

    public void setSpellCastingEntries(Set<SpellCastingEntry> spellCastingEntries) {
        this.spellCastingEntries = spellCastingEntries;
    }
}
