package ru.hackass122.pathfinderhelper.character.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.ProficiencyRank;
import ru.hackass122.pathfinderhelper.common.enums.Skill;
import ru.hackass122.pathfinderhelper.game_data.entity.*;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerCharacter {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String player; // TODO: заменить на Player после реализации

    @Column
    private byte level;

    @Column
    private int experience;

    @Column
    private byte heroPoints;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ancestry_id", nullable = false)
    private Ancestry ancestry;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "heritage_id", nullable = false)
    private Heritage heritage;

    @ManyToMany
    @JoinTable(
            name = "character_traits",
            joinColumns = @JoinColumn(name="character_id"),
            inverseJoinColumns = @JoinColumn(name="trait_id")
    )
    private Set<Trait> traits = new HashSet<>();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "background_id", nullable = false)
    private Background background;

    @Column
    private String backgroundNotes;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false)
    private GameClass gameClass;

    @Column
    private String gameClassNotes;

    @Embedded
    private Attributes attributes;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "armor_id", nullable = false)
    private Armor armor;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "shield_id", nullable = false)
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
}
