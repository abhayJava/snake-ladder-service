package com.intuit.snakeladder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

@AllArgsConstructor
@Getter
public class Dice {
    private int minValue;
    private int maxValue;

    public int roll() {
        return RandomUtils.nextInt(minValue, maxValue + 1);
    }
}
