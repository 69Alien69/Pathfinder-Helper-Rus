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
public class SaveThrows {

    @Column
    private byte fortitude;

    @Column
    private byte reflex;

    @Column
    private byte will;

    //TODO реализовать спасброски
}
