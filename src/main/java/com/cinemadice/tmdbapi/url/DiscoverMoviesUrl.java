package com.cinemadice.tmdbapi.url;

public class DiscoverMoviesUrl extends AbstractDiscoverUrl {

    public DiscoverMoviesUrl() {
        super(Endpoint.DISCOVER_MOVIE);
    }

    public void addRegion(String region) {
        tmdbParameters.put(TmdbParameter.REGION, String.valueOf(region));
    }

    public void addCertificationCountry(String certificationCountry) {
        tmdbParameters.put(TmdbParameter.CERTIFICATION_COUNTRY, String.valueOf(certificationCountry));
    }

    public void addCertification(String certification) {
        tmdbParameters.put(TmdbParameter.CERTIFICATION, String.valueOf(certification));
    }

    public void addCertificationLessThanOrEqual(String certification) {
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

    public void addPrimaryReleaseYear(int year) {
        tmdbParameters.put(TmdbParameter.PRIMARY_RELEASE_YEAR, String.valueOf(year));
    }

    public void addPrimaryReleaseDateLessThanOrEqual(int primaryReleaseDate) {
        tmdbParameters.put(TmdbParameter.PRIMARY_RELEASE_DATE_LTE, String.valueOf(primaryReleaseDate));
    }

    public void addPrimaryReleaseDateGreaterThanOrEqual(int primaryReleaseDate) {
        tmdbParameters.put(TmdbParameter.PRIMARY_RELEASE_DATE_GTE, String.valueOf(primaryReleaseDate));
    }

    public void addReleaseDateLessThanOrEqual(int releaseDate) {
        tmdbParameters.put(TmdbParameter.RELEASE_DATE_LTE, String.valueOf(releaseDate));
    }

    public void addReleaseDateGreaterThanOrEqual(int releaseDate) {
        tmdbParameters.put(TmdbParameter.RELEASE_DATE_GTE, String.valueOf(releaseDate));
    }

    public void addWithReleaseType(int releaseType) {
        tmdbParameters.put(TmdbParameter.WITH_RELEASE_TYPE, String.valueOf(releaseType));
    }

    public void addWithCast(String cast) {
        tmdbParameters.put(TmdbParameter.WITH_CAST, cast);
    }

    public void addWithCrew(String crew) {
        tmdbParameters.put(TmdbParameter.WITH_CREW, crew);
    }

    public void addWithPeople(String people) {
        tmdbParameters.put(TmdbParameter.WITH_PEOPLE, people);
    }

}
