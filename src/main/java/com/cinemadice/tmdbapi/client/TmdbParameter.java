package com.cinemadice.tmdbapi.client;

enum TmdbParameter {
    PAGE("page="),
    API_KEY("api_key=");

    private final String value;

    public String getValue() {
        return value;
    }

    TmdbParameter(String value) {
        this.value = value;
    }

}
