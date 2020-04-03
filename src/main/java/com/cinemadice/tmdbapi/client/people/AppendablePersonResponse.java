package com.cinemadice.tmdbapi.client.people;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  Enum types for responses that can be appended to the person details response.
 *  More info about appending to responses can be found here:
 *  https://developers.themoviedb.org/3/getting-started/append-to-response
 */
@AllArgsConstructor
public enum AppendablePersonResponse {
    IMAGES("images");

    /* TODO: Support following types
    CHANGES("changes"),
    MOVIE_CREDITS("movie_credits"),
    TV_CREDITS("tv_credits"),
    COMBINED_CREDITS("combined_credits"),
    EXTERNAL_IDS("external_ids"),
    TAGGED_IMAGES("tagged_images"),
    TRANSLATIONS("translations"),
     */

    @Getter
    private String value;

}
