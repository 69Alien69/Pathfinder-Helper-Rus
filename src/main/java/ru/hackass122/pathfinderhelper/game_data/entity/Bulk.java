package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Bulk {

    @Column(name = "bulk_units", nullable = false)
    private int units;

    public static final Bulk NEGLIGIBLE  = new Bulk(0);
    public static final Bulk LIGHT = new Bulk(1);

    private Bulk(int units) {
        this.units = units;
    }

    public static Bulk ofBulk(int bulk) {
        return new Bulk(bulk * 10);
    }

    public boolean isNegligible() {
        return units == 0;
    }

    public boolean isLight() {
        return units > 0 && units < 10;
    }

    public int getWholeBulk() {
        return units / 10;
    }

    public int getFractionalUnits() {
        return units % 10;
    }

    @Override
    public String toString() {
        if (isNegligible()) {
            return "Negligible";
        }
        if (isLight()) {
            return "Light";
        }
        int whole = getWholeBulk();
        int frac  = getFractionalUnits();
        return frac == 0
                ? String.valueOf(whole)
                : whole + "." + frac;
    }
}
