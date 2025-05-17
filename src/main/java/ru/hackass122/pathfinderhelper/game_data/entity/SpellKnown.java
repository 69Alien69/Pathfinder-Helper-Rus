package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpellKnown extends AbstractPersistable<Long> {

    @ManyToOne
    private SpellCastingEntry entry;

    @Column
    private int rank;

    @ManyToOne
    private Spell spell;

}
