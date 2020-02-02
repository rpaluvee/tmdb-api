package com.cinemadice.tmdbapi.url;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
enum TmdbParameter {
    API_KEY("api_key="),
    LANGUAGE("language="),
    REGION("region="),
    SORT_BY("sort_by="),
    CERTIFICATION_COUNTRY("certification_country="),
    CERTIFICATION("certification="),
    CERTIFICATION_LTE("certification.lte="),
    CERTIFICATION_GTE("certification.gte="),
    INCLUDE_ADULT("include_adult="),
    INCLUDE_VIDEO("include_video="),
    PAGE("page="),
    PRIMARY_RELEASE_YEAR("primary_release_year="),
    PRIMARY_RELEASE_DATE_GTE("primary_release_date.gte="),
    PRIMARY_RELEASE_DATE_LTE("primary_release_date.lte="),
    RELEASE_DATE_GTE("release_date.gte="),
    RELEASE_DATE_LTE("release_date.lte="),
    WITH_RELEASE_TYPE("with_release_type="),
    VOTE_COUNT_GTE("vote_count.gte="),
    VOTE_COUNT_LTE("vote_count.lte="),
    VOTE_AVERAGE_GTE("vote_average.gte="),
    VOTE_AVERAGE_LTE("vote_average.lte="),
    WITH_CAST("with_cast="),
    WITH_CREW("with_crew="),
    WITH_PEOPLE("with_people="),
    WITH_COMPANIES("with_companies="),
    WITH_GENRES("with_genres="),
    WITHOUT_GENRES("without_genres="),
    WITH_KEYWORDS("with_keywords="),
    WITHOUT_KEYWORDS("without_keywords="),
    WITH_RUNTIME_GTE("with_runtime.gte="),
    WITH_RUNTIME_LTE("with_runtime.lte="),
    WITH_ORIGINAL_LANGUAGE("with_original_language=");

    @Getter
    private final String value;

}
