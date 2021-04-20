package com.emilp.reflections.core.model;

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
