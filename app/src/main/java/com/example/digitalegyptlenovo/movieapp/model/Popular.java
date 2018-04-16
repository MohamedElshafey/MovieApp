package com.example.digitalegyptlenovo.movieapp.model;

import java.util.ArrayList;

/**
 * Created by Mohamed Elshafey on 4/5/2018.
 */
public class Popular {

    private int page;
    private int total_results;
    private int total_pages;
    private ArrayList<Movie> results;

    public Popular(int page, int total_results, int total_pages, ArrayList<Movie> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public ArrayList<Movie> getMovies() {
        return results;
    }
}
