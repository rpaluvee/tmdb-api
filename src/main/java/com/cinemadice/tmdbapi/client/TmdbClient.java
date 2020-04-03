package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.client.discover.TmdbDiscoverClient;
import com.cinemadice.tmdbapi.client.movies.TmdbMoviesClient;
import com.cinemadice.tmdbapi.client.people.TmdbPeopleClient;
import com.cinemadice.tmdbapi.client.tv.TmdbTvClient;
import com.cinemadice.tmdbapi.url.ConfigurationUrl;

public class TmdbClient {

    private final TmdbHttpClient tmdbHttpClient;
    private TmdbDiscoverClient tmdbDiscoverClient;
    private TmdbMoviesClient tmdbMoviesClient;
    private TmdbTvClient tmdbTvClient;
    private TmdbPeopleClient tmdbPeopleClient;

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

    public TmdbMoviesClient movies() {
        if (tmdbMoviesClient == null) {
            this.tmdbMoviesClient = new TmdbMoviesClient(tmdbHttpClient);
        }
        return tmdbMoviesClient;
    }

    public TmdbTvClient tv() {
        if (tmdbTvClient == null) {
            this.tmdbTvClient = new TmdbTvClient(tmdbHttpClient);
        }
        return tmdbTvClient;
    }

    public TmdbPeopleClient people() {
        if (tmdbPeopleClient == null) {
            this.tmdbPeopleClient = new TmdbPeopleClient(tmdbHttpClient);
        }
        return tmdbPeopleClient;
    }

    public TmdbApiConfigurationRequest configuration() {
        return new TmdbApiConfigurationRequest(new ConfigurationUrl(), tmdbHttpClient);
    }

}
