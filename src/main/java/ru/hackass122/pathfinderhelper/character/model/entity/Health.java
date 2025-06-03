package ru.hackass122.pathfinderhelper.character.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;



@Embeddable
public class Health {

    public Health(int maximumHitPoints, int currentHitPoints, int temporaryHitPoints, byte dying, byte wounded, String resistances, String immunities, String weaknesses) {
        this.maximumHitPoints = maximumHitPoints;
        this.currentHitPoints = currentHitPoints;
        this.temporaryHitPoints = temporaryHitPoints;
        this.dying = dying;
        this.wounded = wounded;
        this.resistances = resistances;
        this.immunities = immunities;
        this.weaknesses = weaknesses;
    }

    protected Health() {
    }

    @Column
    private int maximumHitPoints;

    @Column
    private int currentHitPoints;

    @Column
    private int temporaryHitPoints;

    @Column
    private byte dying;

    @Column
    private byte wounded;

    @Column
    private String resistances; // TODO поменять на более подходящее после реализации

    @Column
    private String immunities; // TODO поменять на более подходящее после реализации

    @Column
    private String weaknesses; // TODO поменять на более подходящее после реализации

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

    public int getTemporaryHitPoints() {
        return temporaryHitPoints;
    }

    public void setTemporaryHitPoints(int temporaryHitPoints) {
        this.temporaryHitPoints = temporaryHitPoints;
    }

    public byte getDying() {
        return dying;
    }

    public void setDying(byte dying) {
        this.dying = dying;
    }

    public byte getWounded() {
        return wounded;
    }

    public void setWounded(byte wounded) {
        this.wounded = wounded;
    }

    public String getResistances() {
        return resistances;
    }

    public void setResistances(String resistances) {
        this.resistances = resistances;
    }

    public String getImmunities() {
        return immunities;
    }

    public void setImmunities(String immunities) {
        this.immunities = immunities;
    }

    public String getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(String weaknesses) {
        this.weaknesses = weaknesses;
    }
}
