package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.AbstractPersistable;


@MappedSuperclass
public abstract class RuleElement extends AbstractPersistable<Long> {

    @Column
    private String code;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private boolean deprecated;



}
