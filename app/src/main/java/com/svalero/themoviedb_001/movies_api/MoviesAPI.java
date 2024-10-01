package com.svalero.themoviedb_001.movies_api;

import com.svalero.themoviedb_001.json_mapper.Movie;
import com.svalero.themoviedb_001.json_mapper.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesAPI {
    // Routers!!! express.js
    //@GET("movie/popular?api_key=a4baafc5fd87ddc79d6c8548a8559b9d")
    //Call<MovieResponse> getPopularMovies();
    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies(
            @Query("api_key") String apiKey
    );

    @GET("search/movie")
    Call<MovieResponse> searchMovies(
            @Query("api_key") String apiKey,
            @Query("query") String query);
}
