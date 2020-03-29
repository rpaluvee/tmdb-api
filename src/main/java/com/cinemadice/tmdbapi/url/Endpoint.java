package com.cinemadice.tmdbapi.url;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Endpoint {
    DISCOVER_MOVIE("/discover/movie"),
    UPCOMING_MOVIE("/movie/upcoming"),
    MOVIE_DETAILS("/movie/" + EndpointPlaceholder.MOVIE_ID.getValue()),

    DISCOVER_TV("/discover/tv"),
    TV_AIRING_TODAY("/tv/airing_today"),
    TV_DETAILS("/tv/" + EndpointPlaceholder.TV_ID.getValue()),

    CONFIGURATION("/configuration");

    @Getter
    private String url;

}
