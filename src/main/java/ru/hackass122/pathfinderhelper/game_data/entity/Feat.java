package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import ru.hackass122.pathfinderhelper.game_data.entity.effect.Effect;
import ru.hackass122.pathfinderhelper.game_data.entity.prerequisite.Prerequisite;

import java.util.HashSet;
import java.util.Set;


@Entity
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
    @ManyToMany
    private Set<Prerequisite> prerequisites; // TODO: заменить на подходящую реализацию

    public Feat(Set<Trait> traits, String code, String name, String description, boolean legacy, Long id, int level,
                Set<Effect> effects, Set<Prerequisite> prerequisites) {
        super(traits, code, name, description, legacy, id);
        this.level = level;
        this.effects = effects;
        this.prerequisites = prerequisites;
    }

    protected Feat() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Set<Effect> getEffects() {
        return effects;
    }

    public void setEffects(Set<Effect> effects) {
        this.effects = effects;
    }

    public Set<Prerequisite> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(Set<Prerequisite> prerequisites) {
        this.prerequisites = prerequisites;
    }
}
