package com.emilp.reflections;

import com.emilp.reflections.core.model.Game;
import com.emilp.reflections.core.model.GameMap;
import com.emilp.reflections.core.model.GameType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.Collectors.toList;

@Service
public class GameService {


    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getGames() {
        return Optional.of(gameRepository.findAll())
                .orElse(List.of(getSampleGame(1234567890L)));
    }

    public Game getGame(Long id) {
        return Optional.of(gameRepository.getOne(id))
                .orElse(getSampleGame(12345L));
    }

    public Game addGame(Game game) {
        return gameRepository.save(game);
    }

    public Game getSampleGame(Long id) {
        return Game.builder().id(id)
                .date(Date.valueOf(LocalDate.now()))
                .map(GameMap.ASCENT)
                .gameType(GameType.SCRIM)
                .vodLink(URI.create("https://www.twitch.tv/videos/989729800"))
                .reflections("pew pew pew pew pew")
                .kills(15)
                .deaths(13)
                .assists(5)
                .build();
    }
}
