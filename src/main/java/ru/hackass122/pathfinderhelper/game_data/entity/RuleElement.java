package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.jpa.domain.AbstractPersistable;

@MappedSuperclass
public abstract class RuleElement extends AbstractPersistable<Long> {

    public RuleElement(String code, String name, String description, boolean deprecated, Long id) {
        super.setId(id);
        this.code = code;
        this.name = name;
        this.description = description;
        this.deprecated = deprecated;
    }

    public RuleElement() {
    }

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

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isDeprecated() {
        return this.deprecated;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeprecated(boolean deprecated) {
        this.deprecated = deprecated;
    }
}
