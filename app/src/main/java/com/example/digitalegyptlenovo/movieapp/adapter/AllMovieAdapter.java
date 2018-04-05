package com.example.digitalegyptlenovo.movieapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.digitalegyptlenovo.movieapp.R;
import com.example.digitalegyptlenovo.movieapp.databinding.MovieItemBinding;
import com.example.digitalegyptlenovo.movieapp.model.Movie;

import java.util.ArrayList;

/**
 * Created by Mohamed Elshafey on 4/5/2018.
 */
public class AllMovieAdapter extends BaseAdapter {
    private ArrayList<Movie> mMovies;
    private Context mContext;

    public AllMovieAdapter(Context context, ArrayList<Movie> movies) {
        mContext = context;
        mMovies = movies;
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        MovieItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.movie_item, viewGroup, false);

        return binding.getRoot();
    }

}
