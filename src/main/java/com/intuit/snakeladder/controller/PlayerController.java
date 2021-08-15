package com.intuit.snakeladder.controller;

import com.intuit.snakeladder.model.Board;
import com.intuit.snakeladder.model.Game;
import com.intuit.snakeladder.model.Player;
import com.intuit.snakeladder.model.Players;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

/**
 * {@link PlayerController}  contains all the api's for operating on {@link com.intuit.snakeladder.model.Player}</code>
 */
@RestController
public class PlayerController {

	private Set<Player> players;

	@PostMapping("/player")
	public ResponseEntity<String> init(@RequestBody Player player) {
		boolean isPlayerFound = false;
		for (Player playerItr : players){
			if(playerItr.getId().equalsIgnoreCase(player.getId())){
				player.setPosition(playerItr.getPosition());
				player.setWon(playerItr.getWon());
				player.setName(playerItr.getName());
				isPlayerFound = true;
				break;
			}
		}
		if(!isPlayerFound) {
			player.setId(UUID.randomUUID().toString());
			players.add(player);
		}
		Game.initPlayers(new Players(players));
		return ResponseEntity.ok(!isPlayerFound ? "Player succesfully added" : "Player succesfully updated");
	}

	@RequestMapping("/player")
	public ResponseEntity<Players> getAll() {
		Players players = new Players(this.players);
		return ResponseEntity.ok(players);
	}

	@RequestMapping("/player/{name}")
	public ResponseEntity<Player> getPlayer(@PathVariable String id) {
		Player player = players.stream().filter(p -> p.getId().equalsIgnoreCase(id)).findFirst().get();
		return ResponseEntity.ok(player);
	}



}
	

