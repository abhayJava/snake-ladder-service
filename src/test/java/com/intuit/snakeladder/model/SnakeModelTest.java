package com.intuit.snakeladder.model;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SnakeModelTest {

    private static Logger logger = LogManager.getLogger(SnakeModelTest.class);
    private static Board board;

    @BeforeAll
     static void setup() {
        logger.info("@BeforeAll - executes once before all test methods in this class");
        Snake snake = new Snake(10,20);
        Ladder ladder = new Ladder(8,16);

        board = new Board(100,1, Arrays.asList(snake),Arrays.asList(ladder),new Dice(1,6));
    }


    @Test
    void testBoard(){
        Game.initBoard(board);

        Snake actualSnake = Game.snakePositionMapping.get(board.getSnakes().get(0).getHead());
        Snake expectedSnake = new Snake(10,20);

        Ladder actualLadder = Game.ladderPositionMapping.get(board.getLadders().get(0).getStart());
        Ladder expectedLadder = new Ladder(8,16);
        Assertions.assertEquals(expectedLadder,actualLadder);
    }
}
