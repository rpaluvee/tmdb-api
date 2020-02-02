package com.cinemadice.tmdbapi.url;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
enum Endpoint {
    DISCOVER_MOVIE("/discover/movie");

    @Getter
    private String endpointUrl;

}
