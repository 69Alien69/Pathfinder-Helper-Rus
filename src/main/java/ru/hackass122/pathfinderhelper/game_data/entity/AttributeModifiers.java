package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import ru.hackass122.pathfinderhelper.common.enums.Attribute;

import java.util.HashSet;
import java.util.Set;

@Embeddable
public class AttributeModifiers {
    @ElementCollection(targetClass = Attribute.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "boost", nullable = false)
    private Set<Attribute> boosts = new HashSet<>();

    @ElementCollection(targetClass = Attribute.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "flaw", nullable = false)
    private Set<Attribute> flaws = new HashSet<>();

    public AttributeModifiers(Set<Attribute> boosts, Set<Attribute> flaws) {
        this.boosts = boosts;
        this.flaws = flaws;
    }

    public AttributeModifiers() {
    }

    public Set<Attribute> getBoosts() {
        return boosts;
    }

    public void setBoosts(Set<Attribute> boosts) {
        this.boosts = boosts;
    }

    public Set<Attribute> getFlaws() {
        return flaws;
    }

    public void setFlaws(Set<Attribute> flaws) {
        this.flaws = flaws;
    }
}
