package com.cinemadice.tmdbapi.client;

public class TmdbClient {

    private final String apiKey;

    public TmdbClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public TmdbMoviesClient movies() {
        return new TmdbMoviesClient(apiKey);
    }

}
