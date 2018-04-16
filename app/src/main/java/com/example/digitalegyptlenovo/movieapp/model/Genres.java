package com.example.digitalegyptlenovo.movieapp.model;

import java.util.ArrayList;

/**
 * Created by Mohamed Elshafey on 4/11/2018.
 */
public class Genres {
    private ArrayList<Genre> genres;

    public Genres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }
}
