package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.model.DiscoverMovies;
import com.cinemadice.tmdbapi.model.Movie;
import com.cinemadice.tmdbapi.url.DiscoverMoviesUrl;
import java.net.URL;
import java.util.List;

public class TmdbMoviesRequest extends AbstractTmdbDiscoverRequest<TmdbMoviesRequest> {

    TmdbMoviesRequest(TmdbHttpClient tmdbHttpClient) {
        super.tmdbUrl = new DiscoverMoviesUrl();
        super.tmdbHttpClient = tmdbHttpClient;
    }

    public TmdbMoviesRequest withRegion(String region) {
        ((DiscoverMoviesUrl) tmdbUrl).addRegion(region);
        return this;
    }

    public TmdbMoviesRequest withPrimaryReleaseYear(int year) {
        ((DiscoverMoviesUrl) tmdbUrl).addPrimaryReleaseYear(year);
        return this;
    }

    @Override
    public List<Movie> fetch() {
        URL url = tmdbUrl.build();
        String response = tmdbHttpClient.fetch(url);
        DiscoverMovies discoverMovies = Utils.fromJson(response, DiscoverMovies.class);
        return discoverMovies.getResults();
    }

    @Override
    protected TmdbMoviesRequest getThis() {
        return this;
    }

}
