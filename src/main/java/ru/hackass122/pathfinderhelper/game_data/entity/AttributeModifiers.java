package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hackass122.pathfinderhelper.common.enums.Attribute;

import java.util.HashSet;
import java.util.Set;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttributeModifiers {
    @ElementCollection(targetClass = Attribute.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "boost", nullable = false)
    private Set<Attribute> boosts = new HashSet<>();

    @ElementCollection(targetClass = Attribute.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "flaw", nullable = false)
    private Set<Attribute> flaws = new HashSet<>();
}
