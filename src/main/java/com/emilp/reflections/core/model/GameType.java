package com.emilp.reflections.core.model;

public enum GameType {

    RANKED("ranked"),
    SCRIM("scrim"),
    OTHER("other");

    private final String type;

    GameType(String type) { this.type = type; }

}
