package com.cinemadice.tmdbapi.client.tv;

import com.cinemadice.tmdbapi.client.AbstractTmdbRequest;
import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.model.tv.AdditionalTvDetails;
import com.cinemadice.tmdbapi.url.tv.TvDetailsUrl;
import java.net.URL;

public class TmdbTvDetailsRequest extends AbstractTmdbRequest<TmdbTvDetailsRequest, TvDetailsUrl> {

    TmdbTvDetailsRequest(TmdbHttpClient tmdbHttpClient, int tvId) {
        super(new TvDetailsUrl(tvId), tmdbHttpClient);
    }

    /* TODO: Implement appending results (https://developers.themoviedb.org/3/getting-started/append-to-response)
    public TmdbTvDetailsRequest withAppendedResult(String appendedResult) {
        tmdbUrl.addAppendToResponse(appendedResult);
        return this;
    }
    */

    @Override
    public AdditionalTvDetails fetch() {
        URL url = tmdbUrl.build();
        return tmdbHttpClient.fetch(url, AdditionalTvDetails.class);
    }

    @Override
    protected TmdbTvDetailsRequest thisInstance() {
        return this;
    }

}
