package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.model.Discover;
import com.cinemadice.tmdbapi.model.Movie;
import com.cinemadice.tmdbapi.url.DiscoverMoviesUrlBuilder;

import java.io.Reader;
import java.net.URL;
import java.util.List;

public class TmdbMoviesClient extends AbstractTmdbClient {

    private final DiscoverMoviesUrlBuilder urlBuilder;

    TmdbMoviesClient(String apiKey) {
        this.urlBuilder = new DiscoverMoviesUrlBuilder(apiKey);
    }

    public TmdbMoviesClient withPage(int pageNr) {
        urlBuilder.addPage(pageNr);
        return this;
    }

    public TmdbMoviesClient withPrimaryReleaseYear(int year) {
        urlBuilder.addPrimaryReleaseYear(year);
        return this;
    }

    public List<Movie> fetch() {
        URL url = urlBuilder.build();
        Reader reader = readUrl(url);
        Discover discover = fromJson(reader, Discover.class);
        return discover.getResults();
    }

}
