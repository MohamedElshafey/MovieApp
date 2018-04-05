package com.example.digitalegyptlenovo.movieapp.viewmodel;

import android.databinding.BindingAdapter;
import android.widget.GridView;

import com.example.digitalegyptlenovo.movieapp.adapter.AllMovieAdapter;
import com.example.digitalegyptlenovo.movieapp.model.Movie;

import java.util.ArrayList;

import io.reactivex.annotations.Nullable;

/**
 * Created by Mohamed Elshafey on 4/5/2018.
 */
public class HomeViewModel {

    @BindingAdapter("adapter")
    public static void setAdapter(GridView view, @Nullable boolean test) {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("", ""));
        movies.add(new Movie("", ""));
        movies.add(new Movie("", ""));

        AllMovieAdapter allMovieAdapter = new AllMovieAdapter(view.getContext(), movies);
        view.setAdapter(allMovieAdapter);
    }

}
