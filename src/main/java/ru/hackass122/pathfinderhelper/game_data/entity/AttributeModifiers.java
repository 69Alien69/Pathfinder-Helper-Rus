package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hackass122.pathfinderhelper.common.enums.Attribute;

import java.util.HashSet;
import java.util.Set;

@Embeddable
@Data
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
