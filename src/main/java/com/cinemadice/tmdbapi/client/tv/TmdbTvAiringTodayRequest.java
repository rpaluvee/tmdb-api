package com.cinemadice.tmdbapi.client.tv;

import com.cinemadice.tmdbapi.client.AbstractTmdbRequest;
import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.filter.Language;
import com.cinemadice.tmdbapi.model.tv.TvAiringToday;
import com.cinemadice.tmdbapi.url.tv.TvAiringTodayUrl;

import java.net.URL;

public class TmdbTvAiringTodayRequest extends AbstractTmdbRequest<TmdbTvAiringTodayRequest, TvAiringTodayUrl> {

    TmdbTvAiringTodayRequest(TvAiringTodayUrl tvAiringTodayUrl, TmdbHttpClient tmdbHttpClient) {
        super(tvAiringTodayUrl, tmdbHttpClient);
    }

    public TmdbTvAiringTodayRequest withLanguage(Language language) {
        tmdbUrl.addLanguage(language.getIsoCode());
        return this;
    }

    public TmdbTvAiringTodayRequest withPage(int page) {
        tmdbUrl.addPage(page);
        return this;
    }

    @Override
    public TvAiringToday fetch() {
        URL url = tmdbUrl.build();
        return tmdbHttpClient.fetch(url, TvAiringToday.class);
    }

    @Override
    protected TmdbTvAiringTodayRequest thisInstance() {
        return this;
    }

}
