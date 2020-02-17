package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.url.AbstractDiscoverUrl;
import com.cinemadice.tmdbapi.url.AbstractTmdbUrl;

abstract class AbstractTmdbDiscoverRequest<T, U extends AbstractTmdbUrl> extends AbstractTmdbRequest<T, U> {

    protected AbstractTmdbDiscoverRequest(U tmdbUrl, TmdbHttpClient tmdbHttpClient) {
        super(tmdbUrl, tmdbHttpClient);
    }

    public T withPage(int page) {
        ((AbstractDiscoverUrl) tmdbUrl).addPage(page);
        return thisInstance();
    }

}
