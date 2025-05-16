package ru.hackass122.pathfinderhelper.game_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hackass122.pathfinderhelper.common.enums.ActionCost;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Action extends RuleElement {

    @Enumerated(EnumType.STRING)
    @Column
    private ActionCost actionCost;

    @Column
    private String prerequisites; // TODO: подумать над заменой

    @Column
    private String trigger; // TODO: подумать над заменой




}
