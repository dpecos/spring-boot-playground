package com.danielpecos.springbootplayground.models;

import lombok.Data;

@Data
public class Game {
    private final String name;
    private int releaseDate; // non-final attributes are not included in the constructor args list
}
