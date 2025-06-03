package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Dice {

    @Column(name = "dice_count", nullable = false)
    private int count;

    @Column(name = "dice_sides", nullable = false)
    private int sides;

    public Dice(int count, int sides) {
        this.count = count;
        this.sides = sides;
    }

    protected Dice() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }
}
