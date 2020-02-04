package com.cinemadice.tmdbapi.client;

public class TmdbClient {

    private TmdbMoviesClient tmdbMoviesClient;
    private final String apiKey;

    public TmdbClient(String apiKey) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("Provided API key is invalid");
        }
        this.apiKey = apiKey;
    }

    public TmdbMoviesClient movies() {
        if (tmdbMoviesClient == null) {
            tmdbMoviesClient = new TmdbMoviesClient(apiKey);
        }
        return tmdbMoviesClient;
    }

}
