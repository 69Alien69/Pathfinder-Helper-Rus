package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dice {

    @Column(name = "dice_count", nullable = false)
    private int count;

    @Column(name = "dice_sides", nullable = false)
    private int sides;

}
