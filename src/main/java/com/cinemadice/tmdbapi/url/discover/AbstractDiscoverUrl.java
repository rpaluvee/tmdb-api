package com.cinemadice.tmdbapi.url.discover;

import com.cinemadice.tmdbapi.url.AbstractTmdbUrl;
import com.cinemadice.tmdbapi.url.Endpoint;
import com.cinemadice.tmdbapi.url.TmdbParameter;

public abstract class AbstractDiscoverUrl extends AbstractTmdbUrl {

    protected AbstractDiscoverUrl(Endpoint endpoint) {
        super(endpoint);
    }

    public void addSort(String sortBy) {
        tmdbParameters.put(TmdbParameter.SORT_BY, String.valueOf(sortBy));
    }

    public void addPage(int page) {
        tmdbParameters.put(TmdbParameter.PAGE, String.valueOf(page));
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
