package com.emilp.reflections.api;

import com.emilp.reflections.GameService;
import com.emilp.reflections.core.model.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ApiController {

    @Autowired
    private GameService gameService;

    @GetMapping("/games")
    public ResponseEntity<List<Game>> getGames() {
        return ResponseEntity.ok(gameService.getGames());
    }
    @GetMapping("/game")
    public ResponseEntity<Game> getGame(@RequestParam long id) {
        return ResponseEntity.ok(gameService.getGame(id));
    }

    @GetMapping("/test")
    public ResponseEntity<Game> getTestGame() {
        return ResponseEntity.ok(gameService.getSampleGame(123145L));
    }

    @PostMapping("/add")
    public ResponseEntity addGame(@RequestBody Game game) {

        if (gameService.addGame(game) != null) {
            log.info("adding {}", game);
            return ResponseEntity.ok(game);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }





}
