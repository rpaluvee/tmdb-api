package com.cinemadice.tmdbapi.client.movies;

import com.cinemadice.tmdbapi.Language;
import com.cinemadice.tmdbapi.Region;
import com.cinemadice.tmdbapi.client.AbstractTmdbRequest;
import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.model.movies.UpcomingMovies;
import com.cinemadice.tmdbapi.url.movies.UpcomingMoviesUrl;

import java.net.URL;
import java.util.List;

public class TmdbUpcomingMoviesRequest extends AbstractTmdbRequest<TmdbUpcomingMoviesRequest, UpcomingMoviesUrl> {

    TmdbUpcomingMoviesRequest(UpcomingMoviesUrl upcomingMoviesUrl, TmdbHttpClient tmdbHttpClient) {
        super(upcomingMoviesUrl, tmdbHttpClient);
    }

    public TmdbUpcomingMoviesRequest withLanguage(Language language) {
        tmdbUrl.addLanguage(language.getIsoCode());
        return this;
    }

    public TmdbUpcomingMoviesRequest withPage(int page) {
        tmdbUrl.addPage(page);
        return this;
    }

    public TmdbUpcomingMoviesRequest withRegion(Region region) {
        tmdbUrl.addRegion(region.getIsoCode());
        return this;
    }

    @Override
    public UpcomingMovies fetch() {
        URL url = tmdbUrl.build();
        return tmdbHttpClient.fetch(url, UpcomingMovies.class);
    }

    @Override
    protected TmdbUpcomingMoviesRequest thisInstance() {
        return this;
    }

}
