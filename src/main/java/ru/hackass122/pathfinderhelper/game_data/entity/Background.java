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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.ProficiencyRank;
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

}
