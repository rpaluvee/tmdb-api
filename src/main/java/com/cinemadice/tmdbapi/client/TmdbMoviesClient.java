package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.model.Discover;
import com.cinemadice.tmdbapi.model.Movie;
import com.cinemadice.tmdbapi.url.DiscoverMoviesUrlBuilder;
import com.google.gson.Gson;

import java.io.Reader;
import java.net.URL;
import java.util.List;
import java.util.Optional;

public class TmdbMoviesClient {

    private final DiscoverMoviesUrlBuilder urlBuilder;

    TmdbMoviesClient(String apiKey) {
        this.urlBuilder = new DiscoverMoviesUrlBuilder(apiKey);
    }

    public TmdbMoviesClient withPage(int page) {
        urlBuilder.addPage(page);
        return this;
    }

    public TmdbMoviesClient withPrimaryReleaseYear(int year) {
        urlBuilder.addPrimaryReleaseYear(year);
        return this;
    }

    public List<Movie> fetch() {
        URL url = urlBuilder.build();
        Reader reader = TmdbConnectionManager.openConnection(url).readResponse();
        Discover discover = new Gson().fromJson(reader, Discover.class);
        return discover.getResults();
    }

}
