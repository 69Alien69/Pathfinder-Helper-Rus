package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Material extends Item {

    @Column
    private int hardness;

    @Column
    private int hitPoints;

    @Column
    private int brokenThreshold;

}
