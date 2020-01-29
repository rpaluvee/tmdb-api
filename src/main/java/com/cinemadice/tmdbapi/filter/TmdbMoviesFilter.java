package com.cinemadice.tmdbapi.filter;

import com.cinemadice.tmdbapi.model.Discover;
import com.cinemadice.tmdbapi.model.Movie;
import com.cinemadice.tmdbapi.url.DiscoverMoviesUrl;
import com.cinemadice.tmdbapi.url.TmdbUrl;

import java.util.List;

public class TmdbMoviesFilter extends AbstractTmdbFilter {

    private static final int TOTAL_PAGES = 500;
    private static final int FIRST_PAGE_NR = 1;

    private final DiscoverMoviesUrl tmdbUrl;

    public TmdbMoviesFilter(String apiKey) {
        this.tmdbUrl = new TmdbUrl(apiKey).discoverMovies();
    }

    public TmdbMoviesFilter withPage(int pageNr) {
        tmdbUrl.addPage(pageNr);
        return this;
    }

    public TmdbMoviesFilter withPrimaryReleaseYear(int year) {
        tmdbUrl.addPrimaryReleaseYear(year);
        return this;
    }

    public List<Movie> fetch() {
        Discover discover = deserializeJson(readUrl(tmdbUrl.buildUrl()), Discover.class);
        return discover.getResults();
    }

    public Movie fetchRandom() {
        tmdbUrl.addPage(Utils.generateRandomNr(FIRST_PAGE_NR, TOTAL_PAGES)).buildUrl();
        Discover discover = deserializeJson(readUrl(tmdbUrl.buildUrl()), Discover.class);
        int randomIndex = Utils.generateRandomNr(0, discover.getResults().size() - 1);
        return discover.getResults().get(randomIndex);
    }

}
