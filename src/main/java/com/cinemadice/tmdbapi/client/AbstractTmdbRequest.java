package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.url.TmdbUrl;
import java.util.List;

abstract class AbstractTmdbRequest<T> {

    protected TmdbUrl tmdbUrl;
    protected TmdbHttpClient tmdbHttpClient;

    public T withLanguage(String language) {
        tmdbUrl.addLanguage(language);
        return getThis();
    }

    protected abstract List fetch();

    protected abstract T getThis();

}
