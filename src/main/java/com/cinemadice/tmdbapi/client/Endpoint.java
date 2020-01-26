package com.cinemadice.tmdbapi.client;

enum Endpoint {
    DISCOVER_MOVIE("/discover/movie");

    private String endpointUrl;

    Endpoint(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }

}
