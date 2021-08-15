package com.intuit.snakeladder.controller;

import com.intuit.snakeladder.model.Board;
import com.intuit.snakeladder.model.Game;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import org.springframework.http.ResponseEntity;

/**
 * {@link BoardController} contains all the api's for operating on {@link com.intuit.snakeladder.model.Game}</code>
 */

@RestController
public class BoardController {

	private  Board board;

	@PostMapping("/board")
	public ResponseEntity<String> init(@RequestBody Board board) {

		// Some Validations
		if(board.getSnakes().size() == 0 || board.getLadders().size() == 0){
			return new ResponseEntity<>("\"Atlease one snake or ladder should be provided", null, HttpStatus.BAD_REQUEST);
		}

		if(board.getSnakes().size() > 99 || board.getLadders().size() > 99){
			return new ResponseEntity<>("Cant have more than 99 snake or ladders", null, HttpStatus.PAYLOAD_TOO_LARGE);
		}

		this.board = board;
		Game.initBoard(board);
		return ResponseEntity.ok(this.board == null ? "Board succesfully added" : "Board succesfully updated");
	}

	@RequestMapping("/board")
	public ResponseEntity<Board> get() {
		return ResponseEntity.ok(this.board);
	}



}
	

