package com.svalero.themoviedb_001.json_mapper;

import java.util.List;

public class MovieResponse {
    // URL= https://api.themoviedb.org/3/movie/popular?api_key=a4baafc5fd87ddc79d6c8548a8559b9d

    private List<Movie> results;

    // Getters y Setters aquí
    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
