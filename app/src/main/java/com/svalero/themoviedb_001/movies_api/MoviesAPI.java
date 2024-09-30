package com.svalero.themoviedb_001.movies_api;

import com.svalero.themoviedb_001.json_mapper.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesAPI {
    // Routers!!! express.js
    @GET("movie/popular?api_key=a4baafc5fd87ddc79d6c8548a8559b9d")
    Call<MovieResponse> getPopularMovies();

}
