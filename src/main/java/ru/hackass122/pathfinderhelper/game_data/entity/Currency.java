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
public class Currency {

    @Column
    private int cp;

    @Column
    private int sp;

    @Column
    private int gp;

    @Column
    private int pp;

}
