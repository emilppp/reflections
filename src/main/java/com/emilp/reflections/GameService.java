package com.emilp.reflections;

import com.emilp.reflections.core.exceptions.GameException;
import com.emilp.reflections.core.model.Game;
import com.emilp.reflections.core.model.GameMap;
import com.emilp.reflections.core.model.GameType;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {


    private final GameRepository gameRepository;

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

    public Game updateGame(Game game) throws GameException {
        Game updatedGame = gameRepository.findById(game.getId())
                .map(oldGame -> mergeGame(oldGame, game))
                .orElseThrow(() -> new GameException("No game exists with id " + game.getId()));
        return gameRepository.save(updatedGame);
    }

    private Game mergeGame(Game existingGame, Game updatedGame) {
        Long id = existingGame.getId();
        GameType gameType = updatedGame.getGameType() != null ? updatedGame.getGameType() : existingGame.getGameType();
        GameMap gameMap = updatedGame.getMap() != null ? updatedGame.getMap() : existingGame.getMap();
        URI vodLink = updatedGame.getVodLink() != null ? updatedGame.getVodLink() : existingGame.getVodLink();
        Integer kills = updatedGame.getKills() != null ? updatedGame.getKills() : existingGame.getKills();
        Integer deaths = updatedGame.getDeaths() != null ? updatedGame.getDeaths() : existingGame.getDeaths();
        Integer assists = updatedGame.getAssists() != null ? updatedGame.getAssists() : existingGame.getAssists();
        String reflections = updatedGame.getReflections() != null ? updatedGame.getReflections() : existingGame.getReflections();
        LocalDate date = existingGame.getDate();

        return Game.builder()
                .id(id)
                .gameType(gameType)
                .map(gameMap)
                .vodLink(vodLink)
                .kills(kills)
                .deaths(deaths)
                .assists(assists)
                .reflections(reflections)
                .date(date)
                .build();
    }

    public Game getSampleGame(Long id) {
        return Game.builder().id(id)
                .date(LocalDate.now())
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
