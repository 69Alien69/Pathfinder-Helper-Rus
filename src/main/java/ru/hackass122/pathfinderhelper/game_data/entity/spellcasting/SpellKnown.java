package ru.hackass122.pathfinderhelper.game_data.entity.spellcasting;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class SpellKnown extends AbstractPersistable<Long> {

    @ManyToOne
    private SpellCastingEntry entry;

    @Column
    private int rank;

    @ManyToOne
    private Spell spell;

    public SpellKnown(SpellCastingEntry entry, int rank, Spell spell) {
        this.entry = entry;
        this.rank = rank;
        this.spell = spell;
    }

    protected SpellKnown() {
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

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }
}
