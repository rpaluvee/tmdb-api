package com.cinemadice.tmdbapi.client.tv;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.url.tv.TvAiringTodayUrl;
import com.cinemadice.tmdbapi.url.tv.TvDetailsUrl;

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
        return new TmdbTvAiringTodayRequest(new TvAiringTodayUrl(), tmdbHttpClient);
    }

    public TmdbTvDetailsRequest detailsOf(int tvId) {
        return new TmdbTvDetailsRequest(new TvDetailsUrl(tvId), tmdbHttpClient);
    }

}
