package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;
import ru.hackass122.pathfinderhelper.common.interfaces.Taggable;

import java.util.Set;

@MappedSuperclass
public abstract class TaggableRuleElement extends RuleElement implements Taggable {

    @ManyToMany
    private Set<Trait> traits;

    public TaggableRuleElement(Set<Trait> traits, String code, String name, String description, boolean legacy,
                               Long id) {
        super(code, name, description, legacy, id);
        this.traits = traits;
    }

    public TaggableRuleElement() {
    }

    @Override
    public Set<Trait> getTraits() {
        return traits;
    }

    @Override
    public void setTraits(Set<Trait> traits) {
        this.traits = traits;
    }
}
