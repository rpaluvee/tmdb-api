package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.model.DiscoverMovies;
import com.cinemadice.tmdbapi.model.Movie;
import com.cinemadice.tmdbapi.url.DiscoverMoviesUrl;
import java.net.URL;
import java.util.List;

public class TmdbMoviesRequest extends AbstractTmdbDiscoverRequest<TmdbMoviesRequest, DiscoverMoviesUrl> {

    TmdbMoviesRequest(TmdbHttpClient tmdbHttpClient) {
        super(new DiscoverMoviesUrl(), tmdbHttpClient);
    }

    public TmdbMoviesRequest withRegion(String region) {
        tmdbUrl.addRegion(region);
        return this;
    }

    public TmdbMoviesRequest withPrimaryReleaseYear(int year) {
        tmdbUrl.addPrimaryReleaseYear(year);
        return this;
    }

    @Override
    public List<Movie> fetch() {
        URL url = tmdbUrl.build();
        String response = tmdbHttpClient.fetch(url);
        DiscoverMovies discoverMovies = TmdbHttpClient.fromJson(response, DiscoverMovies.class);
        return discoverMovies.getResults();
    }

    @Override
    protected TmdbMoviesRequest thisInstance() {
        return this;
    }

}
