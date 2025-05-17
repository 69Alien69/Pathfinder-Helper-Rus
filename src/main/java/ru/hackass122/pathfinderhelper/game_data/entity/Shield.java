package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shield extends Item {

    @Column
    private int shieldBonus;

    @Column
    private int speedPenalty;

    @Column
    private int hardness;

    @Column
    private int maximumHitPoints;

    @Column
    private int currentHitPoints;
}
