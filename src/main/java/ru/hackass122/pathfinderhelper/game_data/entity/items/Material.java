package ru.hackass122.pathfinderhelper.game_data.entity.items;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Material extends Item {

    public Material(int hardness, int hitPoints, int brokenThreshold) {
        this.hardness = hardness;
        this.hitPoints = hitPoints;
        this.brokenThreshold = brokenThreshold;
    }

    protected Material() {
    }

    @Column
    private int hardness;

    @Column
    private int hitPoints;

    @Column
    private int brokenThreshold;

    public int getHardness() {
        return hardness;
    }

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getBrokenThreshold() {
        return brokenThreshold;
    }

    public void setBrokenThreshold(int brokenThreshold) {
        this.brokenThreshold = brokenThreshold;
    }
}
