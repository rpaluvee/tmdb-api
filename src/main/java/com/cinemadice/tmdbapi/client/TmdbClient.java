package com.cinemadice.tmdbapi.client;

public class TmdbClient {

    private final String apiKey;

    public TmdbClient(String apiKey) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("Provided API key is invalid");
        }
        this.apiKey = apiKey;
    }

    public TmdbMoviesRequest movies() {
        return new TmdbMoviesRequest(apiKey);
    }

}
