package com.cinemadice.tmdbapi.url;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Endpoint {
    DISCOVER_MOVIE("/discover/movie"),
    DISCOVER_TV("/discover/tv"),
    UPCOMING_MOVIE("/movie/upcoming"),
    MOVIE_DETAILS("/movie/" + EndpointPlaceholder.MOVIE_ID.getValue()),
    TV_DETAILS("/tv/" + EndpointPlaceholder.TV_ID.getValue());

    @Getter
    private String value;

}
