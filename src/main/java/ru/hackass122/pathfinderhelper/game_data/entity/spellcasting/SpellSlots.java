package ru.hackass122.pathfinderhelper.game_data.entity.spellcasting;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class SpellSlots extends AbstractPersistable<Long> {


    @ManyToOne
    private SpellCastingEntry entry;

    @Column
    private int rank;

    @Column
    private int totalSlots;

    @Column
    private int usedSlots;

    public SpellSlots(SpellCastingEntry entry, int rank, int totalSlots, int usedSlots) {
        this.entry = entry;
        this.rank = rank;
        this.totalSlots = totalSlots;
        this.usedSlots = usedSlots;
    }

    protected SpellSlots() {
    }

    public SpellCastingEntry getEntry() {
        return entry;
    }

    public void setEntry(SpellCastingEntry entry) {
        this.entry = entry;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public int getUsedSlots() {
        return usedSlots;
    }

    public void setUsedSlots(int usedSlots) {
        this.usedSlots = usedSlots;
    }
}
