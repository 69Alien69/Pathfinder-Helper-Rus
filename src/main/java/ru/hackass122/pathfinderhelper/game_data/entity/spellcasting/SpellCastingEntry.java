package ru.hackass122.pathfinderhelper.game_data.entity.spellcasting;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.hackass122.pathfinderhelper.common.enums.MagicTradition;

import java.util.List;
import java.util.Set;

@Entity
public class SpellCastingEntry extends AbstractPersistable<Long> {

    @Column
    private MagicTradition magicTradition;

    @Column
    private boolean hasSpells;

    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SpellSlots> slots;

    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SpellKnown> knownSpells;

    public SpellCastingEntry(MagicTradition magicTradition, boolean hasSpells, List<SpellSlots> slots,
                             Set<SpellKnown> knownSpells) {
        this.magicTradition = magicTradition;
        this.hasSpells = hasSpells;
        this.slots = slots;
        this.knownSpells = knownSpells;
    }

    protected SpellCastingEntry() {
    }

    public MagicTradition getMagicTradition() {
        return magicTradition;
    }

    public void setMagicTradition(MagicTradition magicTradition) {
        this.magicTradition = magicTradition;
    }

    public boolean isHasSpells() {
        return hasSpells;
    }

    public void setHasSpells(boolean hasSpells) {
        this.hasSpells = hasSpells;
    }

    public List<SpellSlots> getSlots() {
        return slots;
    }

    public void setSlots(List<SpellSlots> slots) {
        this.slots = slots;
    }

    public Set<SpellKnown> getKnownSpells() {
        return knownSpells;
    }

    public void setKnownSpells(Set<SpellKnown> knownSpells) {
        this.knownSpells = knownSpells;
    }
}
