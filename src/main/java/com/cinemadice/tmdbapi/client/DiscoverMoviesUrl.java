package com.cinemadice.tmdbapi.client;

import java.net.URL;

class DiscoverMoviesUrl {

    private final TmdbUrl tmdbUrl;

    DiscoverMoviesUrl(TmdbUrl tmdbUrl) {
        this.tmdbUrl = tmdbUrl;
    }

    DiscoverMoviesUrl addPage(int pageNr) {
        tmdbUrl.addParameter(TmdbParameter.PAGE, String.valueOf(pageNr));
        return this;
    }

    DiscoverMoviesUrl addPrimaryReleaseYear(int year) {
        tmdbUrl.addParameter(TmdbParameter.PRIMARY_RELEASE_YEAR, Integer.toString(year));
        return this;
    }

    URL buildUrl() {
        return tmdbUrl.buildUrl(Endpoint.DISCOVER_MOVIE);
    }

}
