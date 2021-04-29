package com.emilp.reflections.core.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.net.URI;
import java.time.LocalDate;

@Data
@Builder
@Entity
@Table
public class Game {
    @Id
    @SequenceGenerator(
            name = "game_sequence",
            sequenceName = "game_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "game_sequence"
    )

    private Long id;
    @Enumerated(EnumType.ORDINAL)
    private GameType gameType;
    @Enumerated(EnumType.ORDINAL)
    private GameMap map;
    private URI vodLink;
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private String reflections;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    public Game() {

    }

    public Game(GameType gameType, GameMap map, URI vodLink, Integer kills, Integer deaths, Integer assists, String reflections, LocalDate date) {
        this.gameType = gameType;
        this.map = map;
        this.vodLink = vodLink;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.reflections = reflections;
        this.date = date;
    }

    public Game(Long id, GameType gameType, GameMap map, URI vodLink, Integer kills, Integer deaths, Integer assists, String reflections, LocalDate date) {
        this.id = id;
        this.gameType = gameType;
        this.map = map;
        this.vodLink = vodLink;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.reflections = reflections;
        this.date = date;
    }


}
