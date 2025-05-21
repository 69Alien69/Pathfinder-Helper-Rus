package ru.hackass122.pathfinderhelper.game_data.entity.spellcasting;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.hackass122.pathfinderhelper.common.enums.MagicTradition;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpellCastingEntry extends AbstractPersistable<Long> {

    @Column
    private MagicTradition magicTradition;

    @Column
    private boolean hasSpells;

    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SpellSlots> slots;

    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SpellKnown> knownSpells;


}
