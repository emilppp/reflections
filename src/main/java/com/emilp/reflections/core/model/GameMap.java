package com.emilp.reflections.core.model;

import javax.persistence.Entity;

public enum GameMap {

    ICEBOX("icebox"),
    BIND("bind"),
    SPLIT("split"),
    HAVEN("haven"),
    ASCENT("ascent");

    private final String name;

    private GameMap(String name) {
        this.name = name;
    }
}
