package com.emilp.reflections;

import com.emilp.reflections.core.model.Game;
import com.emilp.reflections.core.model.GameMap;
import com.emilp.reflections.core.model.GameType;
import com.emilp.reflections.core.model.Stats;

import java.net.URI;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static java.util.stream.Collectors.toList;

public class GameService {

    Map<Long, Game> gameStorage = new ConcurrentHashMap<>();

    public List<Game> getGames() {
        return Optional.ofNullable(gameStorage.values().stream().collect(toList()))
                .orElse(List.of(getSampleGame(1234567890L)));
    }

    public Game getGame(Long id) {
        return Optional.ofNullable(gameStorage.get(id))
                .orElse(getSampleGame(12345L));
    }

    public Game addGame(Game game) {
        return gameStorage.put(game.getId(), game);
    }

    public Game getSampleGame(Long id) {
        return Game.builder().id(id)
                .date(Date.valueOf(LocalDate.now()))
                .map(GameMap.ASCENT)
                .gameType(GameType.SCRIM)
                .vodLink(URI.create("https://www.twitch.tv/videos/989729800"))
                .reflections("pew pew pew pew pew")
                .stats(Stats.builder().assists(3).kills(10).deaths(9).build())
                .build();
    }
}
