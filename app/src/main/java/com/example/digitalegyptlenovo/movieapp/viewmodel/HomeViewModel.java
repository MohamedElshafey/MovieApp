package com.example.digitalegyptlenovo.movieapp.viewmodel;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.example.digitalegyptlenovo.movieapp.adapter.AllMovieAdapter;
import com.example.digitalegyptlenovo.movieapp.databinding.ActivityHomeBinding;
import com.example.digitalegyptlenovo.movieapp.model.Genre;
import com.example.digitalegyptlenovo.movieapp.model.Genres;
import com.example.digitalegyptlenovo.movieapp.model.Popular;
import com.example.digitalegyptlenovo.movieapp.sqlite.helper.GenreSqlHelper;
import com.example.digitalegyptlenovo.movieapp.webservice.MovieDbAPiConst;
import com.example.digitalegyptlenovo.movieapp.webservice.RetrofitService;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Mohamed Elshafey on 4/5/2018.
 */

public class HomeViewModel extends BaseObservable {

    private Activity mActivity;

    private Disposable disposable;

    public HomeViewModel(Activity activity, ActivityHomeBinding binding, Retrofit retrofit) {
        mActivity = activity;

        if (GenreSqlHelper.getInstance(mActivity).isTableEmpty())
            getGenresThenGetPopularMovies(retrofit, binding);
        else
            getPopularMovies(retrofit, binding);

    }

    private void getPopularMovies(Retrofit retrofit, ActivityHomeBinding binding) {
        Log.d("HOMEVIEW_MODEL", "getPopularMovies: ");

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);

        Observable<Popular> observable = retrofitService.listPopularMovies(MovieDbAPiConst.api_key, 1);
        disposable = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Popular popular) -> {
                    if (popular != null) {

                        setMoviesAdapter(binding.gridview, popular);

                        binding.progressBar.setVisibility(View.GONE);

                    }
                });
    }

    private void getGenresThenGetPopularMovies(Retrofit retrofit, ActivityHomeBinding binding) {
        Log.d("HOMEVIEW_MODEL", "getGenresThenGetPopularMovies: ");

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);

        Observable<Genres> observable = retrofitService.listGenres(MovieDbAPiConst.api_key);
        disposable = observable.flatMap((Function<Genres, ObservableSource<?>>) genres -> {
            saveGenres(genres);
            return (Observable<Popular>) retrofitService.listPopularMovies(MovieDbAPiConst.api_key, 1);
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object -> {
                    if (object instanceof Popular) {

                        setMoviesAdapter(binding.gridview, (Popular) object);

                        binding.progressBar.setVisibility(View.GONE);

                    }
                });
    }

    private void setMoviesAdapter(GridView gridview, Popular popular) {
        AllMovieAdapter movieAdapter = new AllMovieAdapter(mActivity, popular);

        gridview.setAdapter(movieAdapter);

    }

    private void saveGenres(Genres genres) {
        GenreSqlHelper genreSqlHelper = GenreSqlHelper.getInstance(mActivity);
        for (Genre genre : genres.getGenres()) {
            genreSqlHelper.addNewGenre(genre.getId(), genre.getName());
        }

    }

    public void dispose() {
        if (disposable != null && !disposable.isDisposed())
            disposable.dispose();
    }
}
