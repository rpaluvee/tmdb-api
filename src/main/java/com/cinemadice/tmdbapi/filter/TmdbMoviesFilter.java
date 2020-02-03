package com.cinemadice.tmdbapi.filter;

import com.cinemadice.tmdbapi.model.Discover;
import com.cinemadice.tmdbapi.model.Movie;
import com.cinemadice.tmdbapi.url.DiscoverMoviesUrlBuilder;

import java.io.Reader;
import java.net.URL;
import java.util.List;

public class TmdbMoviesFilter extends AbstractTmdbFilter {

    private static final int FIRST_PAGE_NR = 1;

    private final DiscoverMoviesUrlBuilder urlBuilder;

    public TmdbMoviesFilter(String apiKey) {
        this.urlBuilder = new DiscoverMoviesUrlBuilder(apiKey);
    }

    public TmdbMoviesFilter withPage(int pageNr) {
        urlBuilder.addPage(pageNr);
        return this;
    }

    public TmdbMoviesFilter withPrimaryReleaseYear(int year) {
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
