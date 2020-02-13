package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.model.Discover;
import com.cinemadice.tmdbapi.model.Movie;
import com.cinemadice.tmdbapi.url.DiscoverMoviesUrl;
import java.net.URL;
import java.util.List;

public class TmdbMoviesRequest {

    private final DiscoverMoviesUrl discoverMoviesUrl;
    private final TmdbHttpClient tmdbHttpClient;

    TmdbMoviesRequest(TmdbHttpClient tmdbHttpClient) {
        this.discoverMoviesUrl = new DiscoverMoviesUrl();
        this.tmdbHttpClient = tmdbHttpClient;
    }

    public TmdbMoviesRequest withPage(int page) {
        discoverMoviesUrl.addPage(page);
        return this;
    }

    public TmdbMoviesRequest withPrimaryReleaseYear(int year) {
        discoverMoviesUrl.addPrimaryReleaseYear(year);
        return this;
    }

    public List<Movie> fetch() {
        URL url = discoverMoviesUrl.build();
        String response = tmdbHttpClient.fetch(url);
        Discover discover = Utils.fromJson(response, Discover.class);
        return discover.getResults();
    }

}
