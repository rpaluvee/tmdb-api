package com.cinemadice.tmdbapi.client.tv;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  Enum types for responses that can be appended to the TV details response.
 *  More info about appending to responses can be found here:
 *  https://developers.themoviedb.org/3/getting-started/append-to-response
 */
@AllArgsConstructor
public enum AppendableTvResponse {
    CREDITS("credits"),
    IMAGES("images"),
    VIDEOS("videos");

    /* TODO: Support following types
    ACCOUNT_STATES("account_states"),
    ALTERNATIVE_TITLES("alternative_titles"),
    CHANGES("changes"),
    CONTENT_RATINGS("content_ratings"),
    EPISODE_GROUPS("episode_groups"),
    EXTERNAL_IDS("external_ids"),
    KEYWORDS("keywords"),
    RELEASE_DATES("release_dates"),
    TRANSLATIONS("translations"),
    RECOMMENDATIONS("recommendations"),
    SIMILAR_TV_SHOWS("similar"),
    SCREENED_THEATRICALLY("screened_theatrically"),
    REVIEWS("reviews"),
    LISTS("lists"),
     */

    @Getter
    private String value;

}
