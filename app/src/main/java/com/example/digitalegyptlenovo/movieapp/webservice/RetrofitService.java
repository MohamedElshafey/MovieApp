package com.example.digitalegyptlenovo.movieapp.webservice;

import com.example.digitalegyptlenovo.movieapp.model.Genres;
import com.example.digitalegyptlenovo.movieapp.model.Popular;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Mohamed Elshafey on 4/15/2018.
 */
public interface RetrofitService {

    @GET("genre/movie/list?language=en-US&page=1")
    Observable<Genres> listGenres(@Query("api_key") String api_key);

    @GET("movie/popular?language=en-US")
    Observable<Popular> listPopularMovies(@Query("api_key") String api_key, @Query("page") int page);


}
