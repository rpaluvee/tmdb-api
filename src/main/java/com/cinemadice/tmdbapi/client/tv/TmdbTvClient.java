package com.cinemadice.tmdbapi.client.tv;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;

public class TmdbTvClient {

    private final TmdbHttpClient tmdbHttpClient;

    public TmdbTvClient(TmdbHttpClient tmdbHttpClient) {
        if (tmdbHttpClient == null) {
            throw new IllegalArgumentException(
                    "TmdbHttpClient has to be initialized in TmdbClient with a valid Access Token");
        }
        this.tmdbHttpClient = tmdbHttpClient;
    }

    public TmdbTvAiringTodayRequest airingToday() {
        return new TmdbTvAiringTodayRequest(tmdbHttpClient);
    }

    public TmdbTvDetailsRequest detailsOf(int tvId) {
        return new TmdbTvDetailsRequest(tmdbHttpClient, tvId);
    }

    /* TODO: Implement following methods:
    details()
    latest()
    airingToday()
    onAir()
    popular()
    topRated()
     */

}
