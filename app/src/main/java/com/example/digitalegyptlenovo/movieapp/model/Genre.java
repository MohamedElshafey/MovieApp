package com.example.digitalegyptlenovo.movieapp.model;

/**
 * Created by Mohamed Elshafey on 4/11/2018.
 */
public class Genre {

    private int id;
    private String name;

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
