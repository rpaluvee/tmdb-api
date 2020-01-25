package com.cinemadice.tmdbapi.api;

public class TmdbApi {

    private final String apiKey;

    public TmdbApi(String apiKey) {
        this.apiKey = apiKey;
    }

    public TmdbMoviesApi movies() {
        return new TmdbMoviesApi(apiKey);
    }

}
