package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.jpa.domain.AbstractPersistable;


@MappedSuperclass
public abstract class RuleElement extends AbstractPersistable<Long> {

    @Column(unique = true, nullable = false, updatable = false)
    private String code;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private boolean deprecated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RuleElement that = (RuleElement) o;
        return code != null && code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }
}
