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
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
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

    public Ancestry(int hitPoints, Size size, int speed, AttributeModifiers attributeModifiers, Set<Language> languages,
                    Set<SpecialAbility> specialAbilities, Set<Heritage> heritages, Set<Feat> ancestryFeats,
                    Set<Trait> traits, String code, String name, String description, boolean deprecated, Long id) {
        super(traits, code, name, description, deprecated, id);
        this.hitPoints = hitPoints;
        this.size = size;
        this.speed = speed;
        this.attributeModifiers = attributeModifiers;
        this.languages = languages;
        this.specialAbilities = specialAbilities;
        this.heritages = heritages;
        this.ancestryFeats = ancestryFeats;
    }

    protected Ancestry() {
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public AttributeModifiers getAttributeModifiers() {
        return attributeModifiers;
    }

    public void setAttributeModifiers(AttributeModifiers attributeModifiers) {
        this.attributeModifiers = attributeModifiers;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Set<SpecialAbility> getSpecialAbilities() {
        return specialAbilities;
    }

    public void setSpecialAbilities(Set<SpecialAbility> specialAbilities) {
        this.specialAbilities = specialAbilities;
    }

    public Set<Heritage> getHeritages() {
        return heritages;
    }

    public void setHeritages(Set<Heritage> heritages) {
        this.heritages = heritages;
    }

    public Set<Feat> getAncestryFeats() {
        return ancestryFeats;
    }

    public void setAncestryFeats(Set<Feat> ancestryFeats) {
        this.ancestryFeats = ancestryFeats;
    }

}
