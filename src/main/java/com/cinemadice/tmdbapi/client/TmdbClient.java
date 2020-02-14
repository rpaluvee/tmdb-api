package com.cinemadice.tmdbapi.client;

public class TmdbClient {

    private final TmdbHttpClient tmdbHttpClient;

    public TmdbClient(String accessToken) {
        if (accessToken == null || accessToken.isEmpty()) {
            throw new IllegalArgumentException("Provided API Access Token is invalid");
        }
        this.tmdbHttpClient = new TmdbHttpClient(accessToken);
    }

    public TmdbMoviesRequest movies() {
        return new TmdbMoviesRequest(tmdbHttpClient);
    }

}
