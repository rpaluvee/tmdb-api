package com.cinemadice.tmdbapi.client.discover;

import com.cinemadice.tmdbapi.client.AbstractTmdbRequest;
import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.url.discover.AbstractDiscoverUrl;

abstract class AbstractTmdbDiscoverRequest<T, U extends AbstractDiscoverUrl> extends AbstractTmdbRequest<T, U> {

    protected AbstractTmdbDiscoverRequest(U tmdbUrl, TmdbHttpClient tmdbHttpClient) {
        super(tmdbUrl, tmdbHttpClient);
    }

    public T withPage(int page) {
        tmdbUrl.addPage(page);
        return thisInstance();
    }

}
