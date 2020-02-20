package com.cinemadice.tmdbapi.url;

public class UpcomingMoviesUrl extends AbstractTmdbUrl {

    public UpcomingMoviesUrl() {
        super(Endpoint.UPCOMING_MOVIE);
    }

    public void addRegion(String region) {
        tmdbParameters.put(TmdbParameter.REGION, String.valueOf(region));
    }

    public void addPage(int page) {
        tmdbParameters.put(TmdbParameter.PAGE, String.valueOf(page));
    }

}
