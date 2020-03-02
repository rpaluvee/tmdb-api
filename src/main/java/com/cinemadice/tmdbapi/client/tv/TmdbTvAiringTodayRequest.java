package com.cinemadice.tmdbapi.client.tv;

import com.cinemadice.tmdbapi.client.AbstractTmdbRequest;
import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.model.tv.TvAiringToday;
import com.cinemadice.tmdbapi.model.tv.TvSeries;
import com.cinemadice.tmdbapi.url.tv.TvAiringTodayUrl;
import java.net.URL;
import java.util.List;

public class TmdbTvAiringTodayRequest extends AbstractTmdbRequest<TmdbTvAiringTodayRequest, TvAiringTodayUrl> {

    TmdbTvAiringTodayRequest(TmdbHttpClient tmdbHttpClient) {
        super(new TvAiringTodayUrl(), tmdbHttpClient);
    }

    public TmdbTvAiringTodayRequest withPage(int page) {
        tmdbUrl.addPage(page);
        return this;
    }

    @Override
    public List<TvSeries> fetch() {
        URL url = tmdbUrl.build();
        TvAiringToday tvAiringToday = tmdbHttpClient.fetch(url, TvAiringToday.class);
        return tvAiringToday.getResults();
    }

    @Override
    protected TmdbTvAiringTodayRequest thisInstance() {
        return this;
    }

}
