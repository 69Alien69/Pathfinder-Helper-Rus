package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.AssociationOverrides;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.ProficiencyRank;
import ru.hackass122.pathfinderhelper.common.enums.Size;
import ru.hackass122.pathfinderhelper.common.enums.Skill;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
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

    public Heritage(int hitPointModifier, Size size, AttributeModifiers attributeModifiers,
                    Set<SpecialAbility> specialAbilities, Set<Language> languages,
                    Map<Skill, ProficiencyRank> skillProficiencies, String resistances, int acBonus,
                    Set<Feat> heritageFeats) {
        this.hitPointModifier = hitPointModifier;
        this.size = size;
        this.attributeModifiers = attributeModifiers;
        this.specialAbilities = specialAbilities;
        this.languages = languages;
        this.skillProficiencies = skillProficiencies;
        this.resistances = resistances;
        this.acBonus = acBonus;
        this.heritageFeats = heritageFeats;
    }

    protected Heritage() {
    }

    public int getHitPointModifier() {
        return hitPointModifier;
    }

    public void setHitPointModifier(int hitPointModifier) {
        this.hitPointModifier = hitPointModifier;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public AttributeModifiers getAttributeModifiers() {
        return attributeModifiers;
    }

    public void setAttributeModifiers(AttributeModifiers attributeModifiers) {
        this.attributeModifiers = attributeModifiers;
    }

    public Set<SpecialAbility> getSpecialAbilities() {
        return specialAbilities;
    }

    public void setSpecialAbilities(Set<SpecialAbility> specialAbilities) {
        this.specialAbilities = specialAbilities;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Map<Skill, ProficiencyRank> getSkillProficiencies() {
        return skillProficiencies;
    }

    public void setSkillProficiencies(Map<Skill, ProficiencyRank> skillProficiencies) {
        this.skillProficiencies = skillProficiencies;
    }

    public String getResistances() {
        return resistances;
    }

    public void setResistances(String resistances) {
        this.resistances = resistances;
    }

    public int getAcBonus() {
        return acBonus;
    }

    public void setAcBonus(int acBonus) {
        this.acBonus = acBonus;
    }

    public Set<Feat> getHeritageFeats() {
        return heritageFeats;
    }

    public void setHeritageFeats(Set<Feat> heritageFeats) {
        this.heritageFeats = heritageFeats;
    }
}
