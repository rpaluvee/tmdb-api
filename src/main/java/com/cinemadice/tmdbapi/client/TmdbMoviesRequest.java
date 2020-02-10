package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.model.Discover;
import com.cinemadice.tmdbapi.model.Movie;
import com.cinemadice.tmdbapi.url.DiscoverMoviesUrl;

import java.net.URL;
import java.util.List;
import java.util.Optional;

public class TmdbMoviesRequest {

    private final DiscoverMoviesUrl urlBuilder;

    TmdbMoviesRequest(String apiKey) {
        this.urlBuilder = new DiscoverMoviesUrl(apiKey);
    }

    public TmdbMoviesRequest withPage(int page) {
        urlBuilder.addPage(page);
        return this;
    }

    public TmdbMoviesRequest withPrimaryReleaseYear(int year) {
        urlBuilder.addPrimaryReleaseYear(year);
        return this;
    }

    public List<Movie> fetch() {
        URL url = urlBuilder.build();
        String response = new TmdbHttpClient().fetch(url);
        Discover discover = Utils.fromJson(response, Discover.class);
        return discover.getResults();
    }

}
