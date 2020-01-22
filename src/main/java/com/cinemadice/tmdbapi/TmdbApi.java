package com.cinemadice.tmdbapi;

import com.cinemadice.tmdbapi.methods.TmdbMovies;

public class TmdbApi {

    private final String apiKey;

    public TmdbApi(String apiKey) {
        this.apiKey = apiKey;
    }

    public TmdbMovies getTmdbMovies() {
        return new TmdbMovies(apiKey);
    }

}
