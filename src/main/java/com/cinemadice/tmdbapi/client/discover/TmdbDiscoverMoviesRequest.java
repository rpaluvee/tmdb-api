package com.cinemadice.tmdbapi.client.discover;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.model.DiscoverMovies;
import com.cinemadice.tmdbapi.model.Movie;
import com.cinemadice.tmdbapi.url.discover.DiscoverMoviesUrl;
import java.net.URL;
import java.util.List;

public class TmdbDiscoverMoviesRequest extends
        AbstractTmdbDiscoverRequest<TmdbDiscoverMoviesRequest, DiscoverMoviesUrl> {

    TmdbDiscoverMoviesRequest(TmdbHttpClient tmdbHttpClient) {
        super(new DiscoverMoviesUrl(), tmdbHttpClient);
    }

    public TmdbDiscoverMoviesRequest withRegion(String region) {
        tmdbUrl.addRegion(region);
        return this;
    }

    public TmdbDiscoverMoviesRequest withPrimaryReleaseYear(int year) {
        tmdbUrl.addPrimaryReleaseYear(year);
        return this;
    }

    @Override
    public List<Movie> fetch() {
        URL url = tmdbUrl.build();
        DiscoverMovies discoverMovies = tmdbHttpClient.fetch(url, DiscoverMovies.class);
        return discoverMovies.getResults();
    }

    @Override
    protected TmdbDiscoverMoviesRequest thisInstance() {
        return this;
    }

}
