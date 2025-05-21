package ru.hackass122.pathfinderhelper.character.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
import ru.hackass122.pathfinderhelper.game_data.entity.Ancestry;
import ru.hackass122.pathfinderhelper.game_data.entity.items.Armor;
import ru.hackass122.pathfinderhelper.game_data.entity.Background;
import ru.hackass122.pathfinderhelper.game_data.entity.Feat;
import ru.hackass122.pathfinderhelper.game_data.entity.GameClass;
import ru.hackass122.pathfinderhelper.game_data.entity.Heritage;
import ru.hackass122.pathfinderhelper.game_data.entity.items.Shield;
import ru.hackass122.pathfinderhelper.game_data.entity.Trait;
import ru.hackass122.pathfinderhelper.game_data.entity.items.Weapon;
import ru.hackass122.pathfinderhelper.user.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerCharacter {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String code;

    @Column
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User player;

    @Column
    private int level;

    @Column
    private int experience;

    @Column
    private int heroPoints;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ancestry_id")
    private Ancestry ancestry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "heritage_id")
    private Heritage heritage;

    @ManyToMany
    @JoinTable(
            name = "character_traits",
            joinColumns = @JoinColumn(name="character_id"),
            inverseJoinColumns = @JoinColumn(name="trait_id")
    )
    private Set<Trait> traits = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "background_id")
    private Background background;

    @Column
    private String backgroundNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private GameClass gameClass;

    @Column
    private String gameClassNotes;

    @Embedded
    private Attributes attributes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "armor_id")
    private Armor armor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shield_id")
    private Shield shield;

    @Embedded
    private SaveThrows saveThrows;

    @Column
    private String defensesNotes;

    @Embedded
    private HitPoints hitPoints;

    @ElementCollection
    @CollectionTable(
            name = "character_skill_ranks",
            joinColumns = @JoinColumn(name = "character_id")
    )
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "skill")
    @Column(name = "rank", nullable = false)
    @Enumerated(EnumType.STRING)
    private Map<Skill, ProficiencyRank> skills = new HashMap<>();

    @ElementCollection(targetClass = Language.class, fetch = FetchType.LAZY)
    @CollectionTable(
            name = "character_languages",
            joinColumns = @JoinColumn(name = "character_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "language", nullable = false)
    private Set<Language> languages = new HashSet<>();

    @Column
    private int perception;

    @Column
    private String senses; // TODO: заменить на более подходящую реализацию

    @Column
    private String perceptionNotes;

    @Column
    private int speed;

    @Column
    private String specialMovement; // TODO: заменить на более подходящую реализацию

    @ManyToMany
    @JoinTable(
            name = "character_weapons",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "weapon_id")
    )
    private List<Weapon> weapons = new ArrayList<>();

    @Column
    private int gameClassDifficultyClass;

    @ManyToMany
    @JoinTable(
            name = "character_feats",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "feat_id")
    )
    private Set<Feat> characterFeats = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCharacter that = (PlayerCharacter) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    public Map<Skill, ProficiencyRank> getSkills() {
        return Map.copyOf(skills);
    }

    public void setSkills(Map<Skill, ProficiencyRank> skills) {
        this.skills = skills;
    }
}
