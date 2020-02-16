package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.url.DiscoverUrl;

abstract class AbstractTmdbDiscoverRequest<T> extends AbstractTmdbRequest<T> {

    public T withPage(int page) {
        ((DiscoverUrl) tmdbUrl).addPage(page);
        return getThis();
    }

}
