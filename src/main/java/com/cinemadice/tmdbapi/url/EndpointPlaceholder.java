package com.cinemadice.tmdbapi.url;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EndpointPlaceholder {
    MOVIE_ID("{movie_id}"),
    TV_ID("{tv_id}"),
    PERSON_ID("{person_id}");

    @Getter
    private String value;

}
