package com.cinemadice.tmdbapi.url;

public class DiscoverMoviesUrl extends AbstractTmdbUrl {

    public DiscoverMoviesUrl() {
        super.endpoint = Endpoint.DISCOVER_MOVIE;
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

    public void addPage(int page) {
        tmdbParameters.put(TmdbParameter.PAGE, String.valueOf(page));
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

    public void addVoteCountLessThanOrEqual(int voteCount) {
        tmdbParameters.put(TmdbParameter.VOTE_COUNT_LTE, String.valueOf(voteCount));
    }

    public void addVoteCountGreaterThanOrEqual(int voteCount) {
        tmdbParameters.put(TmdbParameter.VOTE_COUNT_GTE, String.valueOf(voteCount));
    }

    public void addVoteAverageLessThanOrEqual(int voteAverage) {
        tmdbParameters.put(TmdbParameter.VOTE_AVERAGE_LTE, String.valueOf(voteAverage));
    }

    public void addVoteAverageGreaterThanOrEqual(int voteAverage) {
        tmdbParameters.put(TmdbParameter.VOTE_AVERAGE_GTE, String.valueOf(voteAverage));
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

    public void addWithCompanies(String companies) {
        tmdbParameters.put(TmdbParameter.WITH_COMPANIES, companies);
    }

    public void addWithGenres(String genres) {
        tmdbParameters.put(TmdbParameter.WITH_GENRES, genres);
    }

    public void addWithoutGenres(String genres) {
        tmdbParameters.put(TmdbParameter.WITHOUT_GENRES, genres);
    }

    public void addWithKeywords(String keywords) {
        tmdbParameters.put(TmdbParameter.WITH_KEYWORDS, keywords);
    }

    public void addWithoutKeywords(String keywords) {
        tmdbParameters.put(TmdbParameter.WITHOUT_KEYWORDS, keywords);
    }

    public void addWithRuntimeLessThanOrEqual(int runtime) {
        tmdbParameters.put(TmdbParameter.WITH_RUNTIME_LTE, String.valueOf(runtime));
    }

    public void addWithRuntimeGreaterThanOrEqual(int runtime) {
        tmdbParameters.put(TmdbParameter.WITH_RUNTIME_GTE, String.valueOf(runtime));
    }

    public void addWithOriginalLanguage(String language) {
        tmdbParameters.put(TmdbParameter.WITH_ORIGINAL_LANGUAGE, language);
    }

}
