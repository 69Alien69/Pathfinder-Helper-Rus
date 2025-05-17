package ru.hackass122.pathfinderhelper.character.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attributes {

    @Column
    private byte strength;

    @Column
    private byte dexterity;

    @Column
    private byte constitution;

    @Column
    private byte intelligence;

    @Column
    private byte wisdom;

    @Column
    private byte charisma;
}
