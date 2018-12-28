package com.danielpecos.springbootplayground.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class GamesController {

    @RequestMapping("/games")
    public List<String> listGames() {
        return Arrays.asList("Super Mario", "Tetris", "Street Fighter");
    }
}
