package ru.hackass122.pathfinderhelper.character.model.entity;

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

import ru.hackass122.pathfinderhelper.common.enums.ArmorCategory;
import ru.hackass122.pathfinderhelper.common.enums.Language;
import ru.hackass122.pathfinderhelper.common.enums.ProficiencyRank;
import ru.hackass122.pathfinderhelper.common.enums.Size;
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
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Entity
public class PlayerCharacter {

    public PlayerCharacter(long id, String code, String name, User player, int level, int experience, int heroPoints,
                           Ancestry ancestry, Heritage heritage, Set<Trait> traits, Background background,
                           GameClass gameClass, Attributes attributes, Armor armor, Shield shield,
                           SaveThrows saveThrows, Health health, String conditions, Map<Skill, ProficiencyRank> skills,
                           Set<Language> languages, ProficiencyRank perceptionProficiency, String senses, int speed,
                           String specialMovement, List<Weapon> weapons,
                           ProficiencyRank gameClassDifficultyClassProficiency, Set<Feat> characterFeats, Size size,
                           Map<ArmorCategory, ProficiencyRank> armorProficiencies) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.player = player;
        this.level = level;
        this.experience = experience;
        this.heroPoints = heroPoints;
        this.ancestry = ancestry;
        this.heritage = heritage;
        this.traits = traits;
        this.background = background;
        this.gameClass = gameClass;
        this.attributes = attributes;
        this.armor = armor;
        this.shield = shield;
        this.saveThrows = saveThrows;
        this.health = health;
        this.conditions = conditions;
        this.skills = skills;
        this.languages = languages;
        this.perceptionProficiency = perceptionProficiency;
        this.senses = senses;
        this.speed = speed;
        this.specialMovement = specialMovement;
        this.weapons = weapons;
        this.gameClassDifficultyClassProficiency = gameClassDifficultyClassProficiency;
        this.characterFeats = characterFeats;
        this.size = size;
        this.armorProficiencies = armorProficiencies;
    }

    protected PlayerCharacter() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String code;

    @Column
    private String name; // имя персонажа

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User player; // пользователь, которому принадлежит персонаж

    @Column
    private int level; // TODO: заменить на LevelProgression

    @Column
    private int experience; // TODO: заменить на LevelProgression

    @Column
    private int heroPoints; // Очки героя

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ancestry_id")
    private Ancestry ancestry; // народ персонажа

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "heritage_id")
    private Heritage heritage; // родословная персонажа

    @ManyToMany
    @JoinTable(
            name = "character_traits",
            joinColumns = @JoinColumn(name="character_id"),
            inverseJoinColumns = @JoinColumn(name="trait_id")
    )
    private Set<Trait> traits = new HashSet<>(); // дескрипторы

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "background_id")
    private Background background; // происхождение персонажа

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private GameClass gameClass; // класс персонажа

    @Embedded
    private Attributes attributes; // характеристики

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "armor_id")
    private Armor armor; // броня на персонаже

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shield_id")
    private Shield shield; // щит персонажа

    @Embedded
    private SaveThrows saveThrows; // спасброски (испытания)

    @Embedded
    private Health health; // Здоровье персонажа

    @Column
    private String conditions; // TODO поменять на более подходящее после реализации

    @ElementCollection
    @CollectionTable(
            name = "character_skill_ranks",
            joinColumns = @JoinColumn(name = "character_id")
    )
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "skill")
    @Column(name = "rank", nullable = false)
    @Enumerated(EnumType.STRING)
    private Map<Skill, ProficiencyRank> skills = new EnumMap<>(Skill.class); // Уровень мастерства по навыкам

    @ElementCollection(targetClass = Language.class, fetch = FetchType.LAZY)
    @CollectionTable(
            name = "character_languages",
            joinColumns = @JoinColumn(name = "character_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "language", nullable = false)
    private Set<Language> languages = new HashSet<>(); // Языки, которыми владеет персонаж

    @Column
    private ProficiencyRank perceptionProficiency; // уровень мастерства внимания

    @Column
    private String senses; // TODO: заменить на более подходящую реализацию

    @Column
    private int speed; // TODO: заменить на Movement

    @Column
    private String specialMovement; // TODO: заменить на Movement

    @ManyToMany
    @JoinTable(
            name = "character_weapons",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "weapon_id")
    )
    private List<Weapon> weapons = new ArrayList<>(); // Оружие, которым владеет персонаж

    @Column
    private ProficiencyRank gameClassDifficultyClassProficiency; // Умение классовой сложности персонажа

    @ManyToMany
    @JoinTable(
            name = "character_feats",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "feat_id")
    )
    private Set<Feat> characterFeats = new HashSet<>(); // Черты персонажа

    @Column
    private Size size; // Размер персонажа

    @ElementCollection
    @CollectionTable(
            name = "character_armor_ranks",
            joinColumns = @JoinColumn(name = "character_id")
    )
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "armor")
    @Column(name = "rank", nullable = false)
    @Enumerated(EnumType.STRING)
    private Map<ArmorCategory, ProficiencyRank> armorProficiencies = new EnumMap<>(ArmorCategory.class); // умения категорий брони

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getHeroPoints() {
        return heroPoints;
    }

    public void setHeroPoints(int heroPoints) {
        this.heroPoints = heroPoints;
    }

    public Ancestry getAncestry() {
        return ancestry;
    }

    public void setAncestry(Ancestry ancestry) {
        this.ancestry = ancestry;
    }

    public Heritage getHeritage() {
        return heritage;
    }

    public void setHeritage(Heritage heritage) {
        this.heritage = heritage;
    }

    public Set<Trait> getTraits() {
        return traits;
    }

    public void setTraits(Set<Trait> traits) {
        this.traits = traits;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public GameClass getGameClass() {
        return gameClass;
    }

    public void setGameClass(GameClass gameClass) {
        this.gameClass = gameClass;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Shield getShield() {
        return shield;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public SaveThrows getSaveThrows() {
        return saveThrows;
    }

    public void setSaveThrows(SaveThrows saveThrows) {
        this.saveThrows = saveThrows;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public ProficiencyRank getPerceptionProficiency() {
        return perceptionProficiency;
    }

    public void setPerceptionProficiency(ProficiencyRank perceptionProficiency) {
        this.perceptionProficiency = perceptionProficiency;
    }

    public String getSenses() {
        return senses;
    }

    public void setSenses(String senses) {
        this.senses = senses;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getSpecialMovement() {
        return specialMovement;
    }

    public void setSpecialMovement(String specialMovement) {
        this.specialMovement = specialMovement;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public ProficiencyRank getGameClassDifficultyClassProficiency() {
        return gameClassDifficultyClassProficiency;
    }

    public void setGameClassDifficultyClassProficiency(ProficiencyRank gameClassDifficultyClassProficiency) {
        this.gameClassDifficultyClassProficiency = gameClassDifficultyClassProficiency;
    }

    public Set<Feat> getCharacterFeats() {
        return characterFeats;
    }

    public void setCharacterFeats(Set<Feat> characterFeats) {
        this.characterFeats = characterFeats;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Map<ArmorCategory, ProficiencyRank> getArmorProficiencies() {
        return armorProficiencies;
    }

    public void setArmorProficiencies(Map<ArmorCategory, ProficiencyRank> armorProficiencies) {
        this.armorProficiencies = armorProficiencies;
    }
}
