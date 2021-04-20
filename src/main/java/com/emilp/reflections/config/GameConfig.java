package com.emilp.reflections.config;

import com.emilp.reflections.GameService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {


    @Bean
    public GameService gameService() {
        return new GameService();
    }
}