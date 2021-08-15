package com.intuit.snakeladder.service;

import com.intuit.snakeladder.model.*;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * {@link GameService} contains methods for playing the game.
 */
@Service
public class GameService {
    public boolean play(Dice dice, Player player){
        Map<String,Integer> position = Game.playerPosition;

        Map<Integer, Ladder> ladderPosition = Game.ladderPositionMapping;
        Map<Integer, Snake> snakePosition = Game.snakePositionMapping;

        int index = dice.roll();
        int newIndex = position.get(player.getId());

        if(snakePosition.containsKey(newIndex)){
            newIndex = snakePosition.get(newIndex).getTail();
            return  false;
        }
        if(ladderPosition.containsKey(newIndex)){
            newIndex = ladderPosition.get(newIndex).getEnd();
        }

        if(newIndex == 100){
            return true;
        }
        return false;
    }
}
