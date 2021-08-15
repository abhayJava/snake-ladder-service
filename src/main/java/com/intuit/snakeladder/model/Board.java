package com.intuit.snakeladder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Board {
    private int size;
    private int start;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Dice dice;
}
