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

    public Movie fetchRandom() {
        // TODO: Should also check if any filters have been added - if not we don't have to make this extra request
        Discover discover = fromJson(readUrl(urlBuilder.build()), Discover.class);
        urlBuilder.addPage(Utils.generateRandomNr(FIRST_PAGE_NR, discover.getTotalPages()));

        Discover randomPageDiscover = fromJson(readUrl(urlBuilder.build()), Discover.class);
        int randomIndex = Utils.generateRandomNr(0, randomPageDiscover.getResults().size() - 1);
        return discover.getResults().get(randomIndex);
    }

}
