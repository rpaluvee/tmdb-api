package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.url.AbstractDiscoverUrl;

abstract class AbstractTmdbDiscoverRequest<T, U extends AbstractDiscoverUrl> extends AbstractTmdbRequest<T, U> {

    protected AbstractTmdbDiscoverRequest(U tmdbUrl, TmdbHttpClient tmdbHttpClient) {
        super(tmdbUrl, tmdbHttpClient);
    }

    public T withPage(int page) {
        tmdbUrl.addPage(page);
        return thisInstance();
    }

}
