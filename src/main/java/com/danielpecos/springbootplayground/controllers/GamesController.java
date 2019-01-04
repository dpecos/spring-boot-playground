package com.danielpecos.springbootplayground.controllers;

import com.danielpecos.springbootplayground.models.Game;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@Log
public class GamesController {

    @RequestMapping("/games")
    public List<Game> listGames() {
        log.info("Fetching games list...");

        Random yearGenerator = new Random();

        return Stream.of("Super Mario", "Tetris", "Street Fighter")
                .map(title -> {
                    Game g = new Game(title);
                    g.setReleaseDate(yearGenerator.nextInt(2000));
                    return g;
                })
                .collect(Collectors.toList());
    }
}
