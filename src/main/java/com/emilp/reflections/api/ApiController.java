package com.emilp.reflections.api;

import com.emilp.reflections.GameService;
import com.emilp.reflections.core.exceptions.GameException;
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
    public List<Game> getGames() {
        return gameService.getGames();
    }
    @GetMapping("/game")
    public Game getGame(@RequestParam long id) {
        log.info("Getting game with id {}", id);
        return gameService.getGame(id);
    }

    @PostMapping("/add")
    public void addGame(@RequestBody Game game) {
        log.info("Adding game {}", game);
        gameService.addGame(game);
    }

    @PostMapping("/update")
    public Game updateGame(@RequestBody Game game) throws GameException {
        log.info("Updating game with {}", game);
        return gameService.updateGame(game);
    }

}
