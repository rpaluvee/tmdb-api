package com.cinemadice.tmdbapi.url;

public class DiscoverMoviesUrl extends AbstractTmdbUrl {

    public DiscoverMoviesUrl(String apikey) {
        super.endpoint = Endpoint.DISCOVER_MOVIE;
        super.apiKey = apikey;
    }

    public void addLanguage(String language) {
        tmdbParameters.put(TmdbParameter.LANGUAGE, String.valueOf(language));
    }

    public void addRegion(String region) {
        tmdbParameters.put(TmdbParameter.REGION, String.valueOf(region));
    }

    public void addSort(String sortBy) {
        tmdbParameters.put(TmdbParameter.SORT_BY, String.valueOf(sortBy));
    }

    public void addCertificationCountry(String certificationCountry) {
        tmdbParameters.put(TmdbParameter.CERTIFICATION_COUNTRY, String.valueOf(certificationCountry));
    }

    public void addCertification(String certification) {
        tmdbParameters.put(TmdbParameter.CERTIFICATION, String.valueOf(certification));
    }

    public void addCertificationLesserThanOrEqual(String certification) {
        tmdbParameters.put(TmdbParameter.CERTIFICATION_LTE, String.valueOf(certification));
    }

    public void addCertificationGreaterThanOrEqual(String certification) {
        tmdbParameters.put(TmdbParameter.CERTIFICATION_GTE, String.valueOf(certification));
    }

    public void addIncludeAdult(boolean isAdult) {
        tmdbParameters.put(TmdbParameter.INCLUDE_ADULT, String.valueOf(isAdult));
    }

    public void addIncludeVideo(boolean isVideo) {
        tmdbParameters.put(TmdbParameter.INCLUDE_VIDEO, String.valueOf(isVideo));
    }

    public void addPage(int page) {
        tmdbParameters.put(TmdbParameter.PAGE, String.valueOf(page));
    }

    public void addPrimaryReleaseYear(int year) {
        tmdbParameters.put(TmdbParameter.PRIMARY_RELEASE_YEAR, String.valueOf(year));
    }

    public void addPrimaryReleaseDateLesserThanOrEqual(int primaryReleaseDate) {
        tmdbParameters.put(TmdbParameter.PRIMARY_RELEASE_DATE_LTE, String.valueOf(primaryReleaseDate));
    }

    public void addPrimaryReleaseDateGreaterThanOrEqual(int primaryReleaseDate) {
        tmdbParameters.put(TmdbParameter.PRIMARY_RELEASE_DATE_GTE, String.valueOf(primaryReleaseDate));
    }

    public void addReleaseDateLesserThanOrEqual(int releaseDate) {
        tmdbParameters.put(TmdbParameter.RELEASE_DATE_LTE, String.valueOf(releaseDate));
    }

    public void addReleaseDateGreaterThanOrEqual(int releaseDate) {
        tmdbParameters.put(TmdbParameter.RELEASE_DATE_GTE, String.valueOf(releaseDate));
    }

    public void addReleaseType(int releaseType) {
        tmdbParameters.put(TmdbParameter.WITH_RELEASE_TYPE, String.valueOf(releaseType));
    }

}
