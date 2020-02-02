package com.cinemadice.tmdbapi.url;

public class DiscoverMoviesUrlBuilder extends AbstractTmdbUrlBuilder {

    public DiscoverMoviesUrlBuilder(String apikey) {
        super.endpoint = Endpoint.DISCOVER_MOVIE;
        super.apiKey = apikey;
    }

    public DiscoverMoviesUrlBuilder addPage(int page) {
        tmdbParameters.put(TmdbParameter.PAGE, String.valueOf(page));
        return this;
    }

    public DiscoverMoviesUrlBuilder addPrimaryReleaseYear(int year) {
        tmdbParameters.put(TmdbParameter.PRIMARY_RELEASE_YEAR, String.valueOf(year));
        return this;
    }

}
