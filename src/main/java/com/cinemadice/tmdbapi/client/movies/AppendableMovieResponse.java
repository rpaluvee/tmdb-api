package com.cinemadice.tmdbapi.client.movies;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  Enum types for responses that can be appended to the movie details response.
 *  More info about appending to responses can be found here:
 *  https://developers.themoviedb.org/3/getting-started/append-to-response
 */
@AllArgsConstructor
public enum AppendableMovieResponse {
    CREDITS("credits");

    @Getter
    private String value;

}
