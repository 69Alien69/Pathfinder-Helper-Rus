package ru.hackass122.pathfinderhelper.character.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SaveThrows {

    public SaveThrows(byte fortitude, byte reflex, byte will) {
        this.fortitude = fortitude;
        this.reflex = reflex;
        this.will = will;
    }

    protected SaveThrows() {
    }

    @Column
    private byte fortitude;

    @Column
    private byte reflex;

    @Column
    private byte will;

    public byte getFortitude() {
        return fortitude;
    }

    public void setFortitude(byte fortitude) {
        this.fortitude = fortitude;
    }

    public byte getReflex() {
        return reflex;
    }

    public void setReflex(byte reflex) {
        this.reflex = reflex;
    }

    public byte getWill() {
        return will;
    }

    public void setWill(byte will) {
        this.will = will;
    }
}
