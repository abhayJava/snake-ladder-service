package com.intuit.snakeladder.model;

import lombok.Getter;

import java.util.*;

@Getter
public class Game {
    // Note all this have been static to maintain in-memory mapping as db is not use. Ideally all config would be stored/fetched from DB.
    public static Set<Player> players = new HashSet<>();
    public static Board board;
    public static Map<Integer, Snake> snakePositionMapping = new HashMap<Integer,Snake>();
    public static Map<Integer, Ladder> ladderPositionMapping = new HashMap<Integer,Ladder>();
    public static Map<String,Integer> playerPosition = new HashMap<String,Integer>();

    public static void initBoard(Board board) {
        for (Snake snake : board.getSnakes()) {
            snakePositionMapping.put(snake.getHead(), snake);
        }
        for (Ladder ladder : board.getLadders()) {
            ladderPositionMapping.put(ladder.getStart(), ladder);
        }
        Game.board = board;
    }

    public static void initPlayers(Players players){
        Game.players =  players.getPlayers();

        for (Player player : players.getPlayers())
        playerPosition.put(player.getId(),board.getStart());
    }

}
