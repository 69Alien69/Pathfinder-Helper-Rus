package ru.hackass122.pathfinderhelper.game_data.entity.items;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import ru.hackass122.pathfinderhelper.common.enums.ArmorGroup;

@Entity
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

    public Armor(int armorBonus, int dexterityCap, int checkPenalty, int speedPenalty, int strengthRequirement,
                 ArmorGroup armorGroup, Material armorMaterial) {
        this.armorBonus = armorBonus;
        this.dexterityCap = dexterityCap;
        this.checkPenalty = checkPenalty;
        this.speedPenalty = speedPenalty;
        this.strengthRequirement = strengthRequirement;
        this.armorGroup = armorGroup;
        this.armorMaterial = armorMaterial;
    }

    protected Armor() {
    }

    public int getArmorBonus() {
        return armorBonus;
    }

    public void setArmorBonus(int armorBonus) {
        this.armorBonus = armorBonus;
    }

    public int getDexterityCap() {
        return dexterityCap;
    }

    public void setDexterityCap(int dexterityCap) {
        this.dexterityCap = dexterityCap;
    }

    public int getCheckPenalty() {
        return checkPenalty;
    }

    public void setCheckPenalty(int checkPenalty) {
        this.checkPenalty = checkPenalty;
    }

    public int getSpeedPenalty() {
        return speedPenalty;
    }

    public void setSpeedPenalty(int speedPenalty) {
        this.speedPenalty = speedPenalty;
    }

    public int getStrengthRequirement() {
        return strengthRequirement;
    }

    public void setStrengthRequirement(int strengthRequirement) {
        this.strengthRequirement = strengthRequirement;
    }

    public ArmorGroup getArmorGroup() {
        return armorGroup;
    }

    public void setArmorGroup(ArmorGroup armorGroup) {
        this.armorGroup = armorGroup;
    }

    public Material getArmorMaterial() {
        return armorMaterial;
    }

    public void setArmorMaterial(Material armorMaterial) {
        this.armorMaterial = armorMaterial;
    }
}
