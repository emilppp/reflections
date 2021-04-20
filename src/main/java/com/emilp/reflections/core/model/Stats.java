package com.emilp.reflections.core.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Stats {

    private int deaths;
    private int kills;
    private int assists;

}
