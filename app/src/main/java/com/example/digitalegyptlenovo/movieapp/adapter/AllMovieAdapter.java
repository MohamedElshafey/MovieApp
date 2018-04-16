package com.example.digitalegyptlenovo.movieapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.example.digitalegyptlenovo.movieapp.R;
import com.example.digitalegyptlenovo.movieapp.databinding.MovieItemBinding;
import com.example.digitalegyptlenovo.movieapp.model.Movie;
import com.example.digitalegyptlenovo.movieapp.model.Popular;
import com.example.digitalegyptlenovo.movieapp.sqlite.helper.GenreSqlHelper;

import java.util.ArrayList;

/**
 * Created by Mohamed Elshafey on 4/5/2018.
 */
public class AllMovieAdapter extends BaseAdapter {
    private ArrayList<Movie> movies;
    private Context mContext;

    public AllMovieAdapter(Context context, Popular populars) {
        mContext = context;
        movies = populars.getMovies();
    }

    @Override
    public int getCount() {
        return movies.size();
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

        @SuppressLint("ViewHolder") MovieItemBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.movie_item, viewGroup, false);

        Movie movie = movies.get(i);

        String mainImageUrl = "https://image.tmdb.org/t/p/w500";
        String posterPath = movie.getPoster_path();
        String fullImageUrl = mainImageUrl + posterPath;

        Glide.with(mContext).load(fullImageUrl).into(binding.image);

        binding.movieName.setText(movie.getTitle());

        GenreSqlHelper genreSqlHelper = GenreSqlHelper.getInstance(mContext);

        String[] ids = movie.getGenre_ids();

        ArrayList<String> genreNames = genreSqlHelper.getGenreNamesByIds(ids);

        String genres = "";
        for (String genreName : genreNames) {
            genres = genres.concat(genreName);
            if (genreNames.indexOf(genreName) < genreNames.size() - 1)
                genres = genres.concat(" ,");
        }

        binding.info.setText(genres);

        return binding.getRoot();
    }


}
