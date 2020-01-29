package com.cinemadice.tmdbapi.url;

import lombok.Getter;

enum Endpoint {
    DISCOVER_MOVIE("/discover/movie");

    @Getter
    private String endpointUrl;

    Endpoint(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }

}
