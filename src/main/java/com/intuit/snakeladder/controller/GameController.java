package com.intuit.snakeladder.controller;

import com.intuit.snakeladder.model.Board;
import com.intuit.snakeladder.model.Play;
import com.intuit.snakeladder.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * {@link GameController}  contains all the api's for taking different moves {@link Play}</code>
 */
@RestController
public class GameController {

	private  Board board;

	@Autowired
	private GameService gameService;

	@PostMapping("/play")
	public ResponseEntity<String> play(@RequestBody Play play) {
		if(play.getPlayer() == null){
			return new ResponseEntity<>("Player should be specified", null, HttpStatus.BAD_REQUEST);
		}
		boolean hasWon = gameService.play(play.getDice(), play.getPlayer());
		return ResponseEntity.ok(hasWon ? String.format("Player %s won", play.getPlayer().getId()) : "Game in progress");
	}

}
	

