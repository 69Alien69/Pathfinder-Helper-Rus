package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.AssociationOverride;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.ProficiencyRank;
import ru.hackass122.pathfinderhelper.common.enums.Skill;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@AssociationOverride(
        name = "traits",
        joinTable = @JoinTable(
                name = "background_traits",
                joinColumns = @JoinColumn(name = "background_id"),
                inverseJoinColumns = @JoinColumn(name = "traits_id")
        )
)
public class Background extends TaggableRuleElement {

    @ElementCollection
    @CollectionTable(
            name = "background_skill_ranks",
            joinColumns = @JoinColumn(name = "background_id")
    )
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "skill")
    @Column(name = "rank", nullable = false)
    @Enumerated(EnumType.STRING)
    private Map<Skill, ProficiencyRank> skillChoices = new HashMap<>();

    @ManyToMany
    @JoinTable(
            name = "background_lores",
            joinColumns = @JoinColumn(name = "background_id"),
            inverseJoinColumns = @JoinColumn(name = "lore_id")
    )
    private Set<Lore> loreChoices = new HashSet<>();

    @ElementCollection(targetClass = Language.class, fetch = FetchType.LAZY)
    @CollectionTable(
            name = "background_languages",
            joinColumns = @JoinColumn(name = "background_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "language", nullable = false)
    private Set<Language> languages = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "feat_granted_id")
    private Feat featGranted;

    public Background(Map<Skill, ProficiencyRank> skillChoices, Set<Lore> loreChoices, Set<Language> languages, Feat featGranted) {
        this.skillChoices = skillChoices;
        this.loreChoices = loreChoices;
        this.languages = languages;
        this.featGranted = featGranted;
    }

    protected Background() {
    }

    public Map<Skill, ProficiencyRank> getSkillChoices() {
        return skillChoices;
    }

    public void setSkillChoices(Map<Skill, ProficiencyRank> skillChoices) {
        this.skillChoices = skillChoices;
    }

    public Set<Lore> getLoreChoices() {
        return loreChoices;
    }

    public void setLoreChoices(Set<Lore> loreChoices) {
        this.loreChoices = loreChoices;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Feat getFeatGranted() {
        return featGranted;
    }

    public void setFeatGranted(Feat featGranted) {
        this.featGranted = featGranted;
    }
}
