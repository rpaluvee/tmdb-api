package com.cinemadice.tmdbapi.client.movies;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;

public class TmdbMoviesClient {

    private final TmdbHttpClient tmdbHttpClient;

    public TmdbMoviesClient(TmdbHttpClient tmdbHttpClient) {
        if (tmdbHttpClient == null) {
            throw new IllegalArgumentException(
                    "TmdbHttpClient has to be initialized in TmdbClient with a valid Access Token");
        }
        this.tmdbHttpClient = tmdbHttpClient;
    }

    public TmdbUpcomingMoviesRequest upcomingInTheatres() {
        return new TmdbUpcomingMoviesRequest(tmdbHttpClient);
    }

    public TmdbMovieDetailsRequest detailsOf(int movieId) {
        return new TmdbMovieDetailsRequest(tmdbHttpClient, movieId);
    }

    /* TODO: Implement following methods:
    latest()
    playingNow()
    popular()
    topRated()
     */

}
