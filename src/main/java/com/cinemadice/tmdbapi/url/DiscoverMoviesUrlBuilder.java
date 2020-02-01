package com.cinemadice.tmdbapi.url;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DiscoverMoviesUrlBuilder {

    private Map<TmdbParameter, String> tmdbParameters = new HashMap<>();

    DiscoverMoviesUrlBuilder() {}

    public DiscoverMoviesUrlBuilder addApiKey(String apiKey) {
        tmdbParameters.put(TmdbParameter.API_KEY, apiKey);
        return this;
    }

    public DiscoverMoviesUrlBuilder addPage(int page) {
        tmdbParameters.put(TmdbParameter.PAGE, String.valueOf(page));
        return this;
    }

    public DiscoverMoviesUrlBuilder addPrimaryReleaseYear(int year) {
        tmdbParameters.put(TmdbParameter.PRIMARY_RELEASE_YEAR, String.valueOf(year));
        return this;
    }

    public URL build() {
        return new TmdbUrl(tmdbParameters, Endpoint.DISCOVER_MOVIE).buildUrl();
    }

}
