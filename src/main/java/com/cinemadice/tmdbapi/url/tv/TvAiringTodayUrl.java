package com.cinemadice.tmdbapi.url.tv;

import com.cinemadice.tmdbapi.url.AbstractTmdbUrl;
import com.cinemadice.tmdbapi.url.Endpoint;
import com.cinemadice.tmdbapi.url.TmdbParameter;

public class TvAiringTodayUrl extends AbstractTmdbUrl {

    public TvAiringTodayUrl() {
        super(Endpoint.TV_AIRING_TODAY);
    }

    public void addPage(int page) {
        tmdbParameters.put(TmdbParameter.PAGE, String.valueOf(page));
    }

}
