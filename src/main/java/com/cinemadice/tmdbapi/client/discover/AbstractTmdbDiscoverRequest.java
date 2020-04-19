package com.cinemadice.tmdbapi.client.discover;

import com.cinemadice.tmdbapi.client.AbstractTmdbRequest;
import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.filter.Language;
import com.cinemadice.tmdbapi.url.discover.AbstractDiscoverUrl;

abstract class AbstractTmdbDiscoverRequest<T, U extends AbstractDiscoverUrl> extends AbstractTmdbRequest<T, U> {

    protected AbstractTmdbDiscoverRequest(U tmdbUrl, TmdbHttpClient tmdbHttpClient) {
        super(tmdbUrl, tmdbHttpClient);
    }

    public T withLanguage(Language language) {
        tmdbUrl.addLanguage(language.getIsoCode());
        return thisInstance();
    }

    public T withSort(String sortBy) {
        tmdbUrl.addSort(sortBy);
        return thisInstance();
    }

    public T withPage(int page) {
        tmdbUrl.addPage(page);
        return thisInstance();
    }

    public T withVoteCountLessThanOrEqual(int voteCount) {
        tmdbUrl.addVoteCountLessThanOrEqual(voteCount);
        return thisInstance();
    }

    public T withVoteCountGreaterThanOrEqual(int voteCount) {
        tmdbUrl.addVoteCountGreaterThanOrEqual(voteCount);
        return thisInstance();
    }

    public T withVoteAverageLessThanOrEqual(double voteAverage) {
        tmdbUrl.addVoteAverageLessThanOrEqual(voteAverage);
        return thisInstance();
    }

    public T withVoteAverageGreaterThanOrEqual(double voteAverage) {
        tmdbUrl.addVoteAverageGreaterThanOrEqual(voteAverage);
        return thisInstance();
    }

    public T withCompanies(String companies) {
        tmdbUrl.addWithCompanies(companies);
        return thisInstance();
    }

    public T withKeywords(String keywords) {
        tmdbUrl.addWithKeywords(keywords);
        return thisInstance();
    }

    public T withoutKeywords(String keywords) {
        tmdbUrl.addWithoutKeywords(keywords);
        return thisInstance();
    }

    public T withRuntimeLessThanOrEqual(int runtime) {
        tmdbUrl.addWithRuntimeLessThanOrEqual(runtime);
        return thisInstance();
    }

    public T withRuntimeGreaterThanOrEqual(int runtime) {
        tmdbUrl.addWithRuntimeGreaterThanOrEqual(runtime);
        return thisInstance();
    }

    public T withOriginalLanguage(Language language) {
        tmdbUrl.addWithOriginalLanguage(language.getIsoCode());
        return thisInstance();
    }

}
