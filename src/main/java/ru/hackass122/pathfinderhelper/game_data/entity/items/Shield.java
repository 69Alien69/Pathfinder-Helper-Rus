package ru.hackass122.pathfinderhelper.game_data.entity.items;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Shield extends Item {

    @Column
    private int shieldBonus;

    @Column
    private int speedPenalty;

    @Column
    private int hardness;

    @Column
    private int maximumHitPoints;

    @Column
    private int currentHitPoints;

    public Shield(int shieldBonus, int speedPenalty, int hardness, int maximumHitPoints, int currentHitPoints) {
        this.shieldBonus = shieldBonus;
        this.speedPenalty = speedPenalty;
        this.hardness = hardness;
        this.maximumHitPoints = maximumHitPoints;
        this.currentHitPoints = currentHitPoints;
    }

    protected Shield() {
    }

    public int getShieldBonus() {
        return shieldBonus;
    }

    public void setShieldBonus(int shieldBonus) {
        this.shieldBonus = shieldBonus;
    }

    public int getSpeedPenalty() {
        return speedPenalty;
    }

    public void setSpeedPenalty(int speedPenalty) {
        this.speedPenalty = speedPenalty;
    }

    public int getHardness() {
        return hardness;
    }

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    public int getMaximumHitPoints() {
        return maximumHitPoints;
    }

    public void setMaximumHitPoints(int maximumHitPoints) {
        this.maximumHitPoints = maximumHitPoints;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }
}
