package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Currency {

    @Column
    private int cp;

    @Column
    private int sp;

    @Column
    private int gp;

    @Column
    private int pp;

    public Currency(int cp, int sp, int gp, int pp) {
        this.cp = cp;
        this.sp = sp;
        this.gp = gp;
        this.pp = pp;
    }

    protected Currency() {
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getGp() {
        return gp;
    }

    public void setGp(int gp) {
        this.gp = gp;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }
}
