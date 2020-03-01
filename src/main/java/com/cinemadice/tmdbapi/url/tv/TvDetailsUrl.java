package com.cinemadice.tmdbapi.url.tv;

import com.cinemadice.tmdbapi.url.AbstractTmdbUrl;
import com.cinemadice.tmdbapi.url.Endpoint;
import com.cinemadice.tmdbapi.url.EndpointPlaceholder;
import com.cinemadice.tmdbapi.url.TmdbParameter;

public class TvDetailsUrl extends AbstractTmdbUrl {

    public TvDetailsUrl(int tvId) {
        super(Endpoint.TV_DETAILS, EndpointPlaceholder.TV_ID, String.valueOf(tvId));
    }

    public void addAppendToResponse(String appendedResponse) {
        tmdbParameters.put(TmdbParameter.APPEND_TO_RESPONSE, appendedResponse);
    }

}
