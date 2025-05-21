package ru.hackass122.pathfinderhelper.common.enums;

import lombok.Getter;

import java.util.Optional;

@Getter
public enum ProficiencyRank {
    UNTRAINED(0),
    TRAINED(2),
    EXPERT(4),
    MASTER(6),
    LEGENDARY(8);

    /**
     *  Базовый бонус, даваемый этим уровнем мастерства (без учёта уровня персонажа).
     */
    private final int bonus;

    ProficiencyRank(int bonus) {
        this.bonus = bonus;
    }

    /**
     * Возвращает следующий уровень мастерства, если такой существует
     * Если достигнут максимальный уровень, возвращает пустой Optional
     * @return next proficiency level or empty optional if level already at maximum
     */
    public Optional<ProficiencyRank> next() {
        return switch (this) {
            case UNTRAINED -> Optional.of(TRAINED);
            case TRAINED -> Optional.of(EXPERT);
            case EXPERT -> Optional.of(MASTER);
            case MASTER -> Optional.of(LEGENDARY);
            case LEGENDARY -> Optional.empty();
        };
    }
}
