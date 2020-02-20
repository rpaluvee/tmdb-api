package com.cinemadice.tmdbapi.url;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
enum Endpoint {
    DISCOVER_MOVIE("/discover/movie"),
    DISCOVER_TV("/discover/tv"),
    UPCOMING_MOVIE("/movie/upcoming");

    @Getter
    private String endpointUrl;

}
