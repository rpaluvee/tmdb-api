package com.cinemadice.tmdbapi.client.movies;

import com.cinemadice.tmdbapi.client.AbstractTmdbRequest;
import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.model.MovieDetails;
import com.cinemadice.tmdbapi.url.movies.MovieDetailsUrl;
import java.net.URL;

public class TmdbMovieDetailsRequest extends AbstractTmdbRequest<TmdbMovieDetailsRequest, MovieDetailsUrl> {

    TmdbMovieDetailsRequest(TmdbHttpClient tmdbHttpClient, int movieId) {
        super(new MovieDetailsUrl(movieId), tmdbHttpClient);
    }

    /* TODO: Implement appending results (https://developers.themoviedb.org/3/getting-started/append-to-response)
    public TmdbMovieDetailsRequest withAppendedResult(String appendedResult) {
        tmdbUrl.addAppendToResponse(appendedResult);
        return this;
    }
    */

    @Override
    public MovieDetails fetch() {
        URL url = tmdbUrl.build();
        return tmdbHttpClient.fetch(url, MovieDetails.class);
    }

    @Override
    protected TmdbMovieDetailsRequest thisInstance() {
        return this;
    }

}
