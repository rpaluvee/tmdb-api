package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.url.AbstractTmdbUrl;

public abstract class AbstractTmdbRequest<T, U extends AbstractTmdbUrl> {

    protected final U tmdbUrl;
    protected final TmdbHttpClient tmdbHttpClient;

    protected AbstractTmdbRequest(U tmdbUrl, TmdbHttpClient tmdbHttpClient) {
        this.tmdbUrl = tmdbUrl;
        this.tmdbHttpClient = tmdbHttpClient;
    }

    protected abstract Object fetch();

    protected abstract T thisInstance();

}
