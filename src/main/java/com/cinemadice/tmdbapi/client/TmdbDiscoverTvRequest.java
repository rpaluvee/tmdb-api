package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.model.DiscoverTv;
import com.cinemadice.tmdbapi.model.TvSeries;
import com.cinemadice.tmdbapi.url.discover.DiscoverTvUrl;
import java.net.URL;
import java.util.List;

public class TmdbDiscoverTvRequest extends AbstractTmdbDiscoverRequest<TmdbDiscoverTvRequest, DiscoverTvUrl> {

    TmdbDiscoverTvRequest(TmdbHttpClient tmdbHttpClient) {
        super(new DiscoverTvUrl(), tmdbHttpClient);
    }

    public TmdbDiscoverTvRequest withTimezone(String timezone) {
        tmdbUrl.addTimezone(timezone);
        return this;
    }

    @Override
    public List<TvSeries> fetch() {
        URL url = tmdbUrl.build();
        DiscoverTv discoverTv = tmdbHttpClient.fetch(url, DiscoverTv.class);
        return discoverTv.getResults();
    }

    @Override
    protected TmdbDiscoverTvRequest thisInstance() {
        return this;
    }

}
