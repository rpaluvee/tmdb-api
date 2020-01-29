package com.cinemadice.tmdbapi.url;

import java.net.URL;

public class DiscoverMoviesUrl {

    private final TmdbUrl tmdbUrl;

    DiscoverMoviesUrl(TmdbUrl tmdbUrl) {
        this.tmdbUrl = tmdbUrl;
    }

    public DiscoverMoviesUrl addPage(int pageNr) {
        tmdbUrl.addParameter(TmdbParameter.PAGE, String.valueOf(pageNr));
        return this;
    }

    public DiscoverMoviesUrl addPrimaryReleaseYear(int year) {
        tmdbUrl.addParameter(TmdbParameter.PRIMARY_RELEASE_YEAR, Integer.toString(year));
        return this;
    }

    public URL buildUrl() {
        return tmdbUrl.buildUrl(Endpoint.DISCOVER_MOVIE);
    }

}
