package com.emilp.reflections.core.model;

import lombok.Builder;
import lombok.Value;

import java.net.URI;
import java.util.Date;

@Value
@Builder
public class Game {

    private Long id;
    private GameType gameType;
    private GameMap map;
    private URI vodLink;
    private Stats stats;
    private String reflections;
    private Date date;
}
