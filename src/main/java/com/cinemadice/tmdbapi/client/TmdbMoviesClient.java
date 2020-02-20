package com.cinemadice.tmdbapi.client;

public class TmdbMoviesClient {

    private final TmdbHttpClient tmdbHttpClient;

    TmdbMoviesClient(TmdbHttpClient tmdbHttpClient) {
        this.tmdbHttpClient = tmdbHttpClient;
    }

    public TmdbUpcomingMoviesRequest upcomingInTheatres() {
        return new TmdbUpcomingMoviesRequest(tmdbHttpClient);
    }

    /* TODO: Implement following methods:
    details()
    latest()
    playingNow()
    popular()
    topRated()
     */

}
