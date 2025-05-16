package ru.hackass122.pathfinderhelper.character.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HitPoints {

    @Column
    private int maximumHitPoints;

    @Column
    private int currentHitPoints;

    @Column
    private int temporaryHitPoints;

    @Column
    private byte dying;

    @Column
    private byte wounded;

    @Column
    private String resistances; // TODO поменять на более подходящее после реализации

    @Column
    private String immunities; // TODO поменять на более подходящее после реализации

    @Column
    private String conditions; // TODO поменять на более подходящее после реализации
}
