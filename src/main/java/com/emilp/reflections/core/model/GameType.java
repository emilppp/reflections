package com.emilp.reflections.core.model;

import javax.persistence.Entity;

public enum GameType {

    RANKED("ranked"),
    SCRIM("scrim"),
    OTHER("other");

    private final String type;

    GameType(String type) { this.type = type; }

}
