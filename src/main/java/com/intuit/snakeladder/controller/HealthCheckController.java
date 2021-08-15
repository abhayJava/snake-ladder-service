package com.intuit.snakeladder.controller;

import com.intuit.snakeladder.SnakeLadderApplication;
import com.intuit.snakeladder.model.Player;
import com.intuit.snakeladder.model.Players;
import com.intuit.snakeladder.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

/**
 * {@link HealthCheckController} contains healthcheck apis</code>
 */
@RestController
public class HealthCheckController {

	@RequestMapping("/health")
	public ResponseEntity<String> getHealth() {
		return ResponseEntity.ok("Snake Ladder Service is Up!");
	}



}
	

