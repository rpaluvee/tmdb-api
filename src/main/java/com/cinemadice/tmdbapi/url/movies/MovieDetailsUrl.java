package com.cinemadice.tmdbapi.url.movies;

import com.cinemadice.tmdbapi.url.AbstractTmdbUrl;
import com.cinemadice.tmdbapi.url.Endpoint;
import com.cinemadice.tmdbapi.url.EndpointPlaceholder;
import com.cinemadice.tmdbapi.url.TmdbParameter;

public class MovieDetailsUrl extends AbstractTmdbUrl {

    public MovieDetailsUrl(int movieId) {
        super(Endpoint.MOVIE_DETAILS, EndpointPlaceholder.MOVIE_ID, String.valueOf(movieId));
    }

    public void addAppendToResponse(String appendedResponse) {
        tmdbParameters.put(TmdbParameter.APPEND_TO_RESPONSE, appendedResponse);
    }

}
