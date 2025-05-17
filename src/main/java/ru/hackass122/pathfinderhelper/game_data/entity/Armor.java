package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hackass122.pathfinderhelper.common.enums.ArmorGroup;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Armor extends Item {

    @Column
    private int armorBonus;

    @Column
    private int dexterityCap;

    @Column
    private int checkPenalty;

    @Column
    private int speedPenalty;

    @Column
    private int strengthRequirement;

    @Enumerated(EnumType.STRING)
    @Column
    private ArmorGroup armorGroup;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "material_id", nullable = false)
    private Material armorMaterial;

}
