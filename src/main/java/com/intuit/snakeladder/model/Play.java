package com.intuit.snakeladder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Play {
    private Dice dice;
    private Player player;
}
