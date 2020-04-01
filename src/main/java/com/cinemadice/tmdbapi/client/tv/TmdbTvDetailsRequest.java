package com.cinemadice.tmdbapi.client.tv;

import com.cinemadice.tmdbapi.Language;
import com.cinemadice.tmdbapi.client.AbstractTmdbRequest;
import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.model.tv.TvDetails;
import com.cinemadice.tmdbapi.url.tv.TvDetailsUrl;

import java.net.URL;

public class TmdbTvDetailsRequest extends AbstractTmdbRequest<TmdbTvDetailsRequest, TvDetailsUrl> {

    TmdbTvDetailsRequest(TvDetailsUrl tvDetailsUrl, TmdbHttpClient tmdbHttpClient) {
        super(tvDetailsUrl, tmdbHttpClient);
    }

    public TmdbTvDetailsRequest withLanguage(Language language) {
        tmdbUrl.addLanguage(language.getIsoCode());
        return this;
    }

    /* TODO: Implement appending results (https://developers.themoviedb.org/3/getting-started/append-to-response)
    public TmdbTvDetailsRequest withAppendedResult(String appendedResult) {
        tmdbUrl.addAppendToResponse(appendedResult);
        return this;
    }
    */

    @Override
    public TvDetails fetch() {
        URL url = tmdbUrl.build();
        return tmdbHttpClient.fetch(url, TvDetails.class);
    }

    @Override
    protected TmdbTvDetailsRequest thisInstance() {
        return this;
    }

}
