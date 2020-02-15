package com.cinemadice.tmdbapi.url;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
enum Endpoint {
    DISCOVER_MOVIE("/discover/movie"),
    DISCOVER_TV("/discover/tv");

    @Getter
    private String endpointUrl;

}
