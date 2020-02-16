package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.model.DiscoverTv;
import com.cinemadice.tmdbapi.model.TvSeries;
import com.cinemadice.tmdbapi.url.DiscoverTvUrl;
import java.net.URL;
import java.util.List;

public class TmdbTvRequest extends AbstractTmdbDiscoverRequest<TmdbTvRequest> {

    TmdbTvRequest(TmdbHttpClient tmdbHttpClient) {
        super.tmdbUrl = new DiscoverTvUrl();
        super.tmdbHttpClient = tmdbHttpClient;
    }

    public TmdbTvRequest withTimezone(String timezone) {
        ((DiscoverTvUrl) tmdbUrl).addTimezone(timezone);
        return this;
    }

    @Override
    public List<TvSeries> fetch() {
        URL url = tmdbUrl.build();
        String response = tmdbHttpClient.fetch(url);
        DiscoverTv discoverTv = Utils.fromJson(response, DiscoverTv.class);
        return discoverTv.getResults();
    }

    @Override
    protected TmdbTvRequest getThis() {
        return this;
    }

}
