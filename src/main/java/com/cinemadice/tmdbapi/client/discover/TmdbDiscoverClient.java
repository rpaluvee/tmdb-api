package com.cinemadice.tmdbapi.client.discover;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;

public class TmdbDiscoverClient {

    private final TmdbHttpClient tmdbHttpClient;

    public TmdbDiscoverClient(TmdbHttpClient tmdbHttpClient) {
        if (tmdbHttpClient == null) {
            throw new IllegalArgumentException(
                    "TmdbHttpClient has to be initialized in TmdbClient with a valid Access Token");
        }
        this.tmdbHttpClient = tmdbHttpClient;
    }

    public TmdbDiscoverMoviesRequest movies() {
        return new TmdbDiscoverMoviesRequest(tmdbHttpClient);
    }

    public TmdbDiscoverTvRequest tv() {
        return new TmdbDiscoverTvRequest(tmdbHttpClient);
    }

}
