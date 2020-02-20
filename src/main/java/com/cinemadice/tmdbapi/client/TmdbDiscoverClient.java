package com.cinemadice.tmdbapi.client;

public class TmdbDiscoverClient {

    private final TmdbHttpClient tmdbHttpClient;

    TmdbDiscoverClient(TmdbHttpClient tmdbHttpClient) {
        this.tmdbHttpClient = tmdbHttpClient;
    }

    public TmdbDiscoverMoviesRequest movies() {
        return new TmdbDiscoverMoviesRequest(tmdbHttpClient);
    }

    public TmdbDiscoverTvRequest tv() {
        return new TmdbDiscoverTvRequest(tmdbHttpClient);
    }

}
