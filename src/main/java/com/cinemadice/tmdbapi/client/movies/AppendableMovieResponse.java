package com.cinemadice.tmdbapi.client.movies;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  Enum types for responses that can be appended to the movie details response.
 *  More info about appending to responses can be found here:
 *  https://developers.themoviedb.org/3/getting-started/append-to-response
 */
@AllArgsConstructor
public enum AppendableMovieResponse {
    CREDITS("credits"),
    IMAGES("images");

    /* TODO: Support following types
    ACCOUNT_STATES("account_states"),
    ALTERNATIVE_TITLES("alternative_titles"),
    CHANGES("changes"),
    EXTERNAL_IDS("external_ids"),
    KEYWORDS("keywords"),
    RELEASE_DATES("release_dates"),
    VIDEOS("videos"),
    TRANSLATIONS("translations"),
    RECOMMENDATIONS("recommendations"),
    SIMILAR_MOVIES("similar"),
    REVIEWS("reviews"),
    LISTS("lists"),
     */

    @Getter
    private String value;

}
