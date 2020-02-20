package com.cinemadice.tmdbapi.client;

public class TmdbClient {

    private final TmdbHttpClient tmdbHttpClient;
    private TmdbDiscoverClient tmdbDiscoverClient;

    public TmdbClient(String accessToken) {
        if (accessToken == null || accessToken.isEmpty()) {
            throw new IllegalArgumentException("Provided API Access Token is invalid");
        }
        this.tmdbHttpClient = new TmdbHttpClient(accessToken);
    }

    public TmdbDiscoverClient discover() {
        if (tmdbDiscoverClient == null) {
            this.tmdbDiscoverClient = new TmdbDiscoverClient(tmdbHttpClient);
        }
        return tmdbDiscoverClient;
    }

    public TmdbTvRequest tv() {
        return new TmdbTvRequest(tmdbHttpClient);
    }

}
