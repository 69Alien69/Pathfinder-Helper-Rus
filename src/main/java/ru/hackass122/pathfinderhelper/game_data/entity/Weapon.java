package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hackass122.pathfinderhelper.common.enums.DamageType;
import ru.hackass122.pathfinderhelper.common.enums.WeaponCategory;
import ru.hackass122.pathfinderhelper.common.enums.WeaponGroup;
import ru.hackass122.pathfinderhelper.common.enums.WeaponType;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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


}
