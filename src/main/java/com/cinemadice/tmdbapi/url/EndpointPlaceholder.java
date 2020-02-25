package com.cinemadice.tmdbapi.url;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EndpointPlaceholder {
    MOVIE_ID("{movie_id}");

    @Getter
    private String value;

}
