package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.filter.TmdbMoviesFilter;
import com.cinemadice.tmdbapi.model.Movie;

public class TmdbMoviesClient {

    private final String apiKey;

    TmdbMoviesClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public TmdbMoviesFilter filter() {
        return new TmdbMoviesFilter(apiKey);
    }

}
