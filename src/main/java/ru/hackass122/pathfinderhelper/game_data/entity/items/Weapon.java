package ru.hackass122.pathfinderhelper.game_data.entity.items;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import ru.hackass122.pathfinderhelper.common.enums.DamageType;
import ru.hackass122.pathfinderhelper.common.enums.WeaponCategory;
import ru.hackass122.pathfinderhelper.common.enums.WeaponGroup;
import ru.hackass122.pathfinderhelper.common.enums.WeaponType;
import ru.hackass122.pathfinderhelper.game_data.entity.Dice;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Weapon extends Item {

    @Enumerated(EnumType.STRING)
    @Column
    private WeaponType weaponType;

    @Enumerated(EnumType.STRING)
    @Column
    private WeaponCategory weaponCategory;

    @Enumerated(EnumType.STRING)
    @Column
    private WeaponGroup weaponGroup;

    @Column
    private int hands;

    @Embedded
    private Dice damage;

    @Enumerated(EnumType.STRING)
    @Column
    private DamageType damageType;

    @Column
    private int range;

    @Column
    private int reload;

    @ManyToMany
    @JoinTable(
            name = "weapon_ammunition",
            joinColumns = @JoinColumn(name="weapon_id"),
            inverseJoinColumns = @JoinColumn(name="ammunition_id")
    )
    private Set<Item> ammunition = new HashSet<>();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "material_id", nullable = false)
    private Material weaponMaterial;

    public Weapon(WeaponType weaponType, WeaponCategory weaponCategory, WeaponGroup weaponGroup, int hands, Dice damage,
                  DamageType damageType, int range, int reload, Set<Item> ammunition, Material weaponMaterial) {
        this.weaponType = weaponType;
        this.weaponCategory = weaponCategory;
        this.weaponGroup = weaponGroup;
        this.hands = hands;
        this.damage = damage;
        this.damageType = damageType;
        this.range = range;
        this.reload = reload;
        this.ammunition = ammunition;
        this.weaponMaterial = weaponMaterial;
    }

    protected Weapon() {
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public WeaponCategory getWeaponCategory() {
        return weaponCategory;
    }

    public void setWeaponCategory(WeaponCategory weaponCategory) {
        this.weaponCategory = weaponCategory;
    }

    public WeaponGroup getWeaponGroup() {
        return weaponGroup;
    }

    public void setWeaponGroup(WeaponGroup weaponGroup) {
        this.weaponGroup = weaponGroup;
    }

    public int getHands() {
        return hands;
    }

    public void setHands(int hands) {
        this.hands = hands;
    }

    public Dice getDamage() {
        return damage;
    }

    public void setDamage(Dice damage) {
        this.damage = damage;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getReload() {
        return reload;
    }

    public void setReload(int reload) {
        this.reload = reload;
    }

    public Set<Item> getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(Set<Item> ammunition) {
        this.ammunition = ammunition;
    }

    public Material getWeaponMaterial() {
        return weaponMaterial;
    }

    public void setWeaponMaterial(Material weaponMaterial) {
        this.weaponMaterial = weaponMaterial;
    }

}
