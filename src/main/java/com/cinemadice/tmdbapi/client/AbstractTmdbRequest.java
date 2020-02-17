package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.url.AbstractTmdbUrl;
import java.util.List;

abstract class AbstractTmdbRequest<T, U extends AbstractTmdbUrl> {

    protected final U tmdbUrl;
    protected final TmdbHttpClient tmdbHttpClient;

    protected AbstractTmdbRequest(U tmdbUrl, TmdbHttpClient tmdbHttpClient) {
        this.tmdbUrl = tmdbUrl;
        this.tmdbHttpClient = tmdbHttpClient;
    }

    public T withLanguage(String language) {
        tmdbUrl.addLanguage(language);
        return thisInstance();
    }

    protected abstract List<?> fetch();

    protected abstract T thisInstance();

}
