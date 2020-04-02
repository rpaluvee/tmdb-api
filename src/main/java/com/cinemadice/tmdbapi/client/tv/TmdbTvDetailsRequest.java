package com.cinemadice.tmdbapi.client.tv;

import com.cinemadice.tmdbapi.client.AbstractTmdbRequest;
import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.filter.Language;
import com.cinemadice.tmdbapi.model.tv.TvDetails;
import com.cinemadice.tmdbapi.url.tv.TvDetailsUrl;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TmdbTvDetailsRequest extends AbstractTmdbRequest<TmdbTvDetailsRequest, TvDetailsUrl> {

    TmdbTvDetailsRequest(TvDetailsUrl tvDetailsUrl, TmdbHttpClient tmdbHttpClient) {
        super(tvDetailsUrl, tmdbHttpClient);
    }

    public TmdbTvDetailsRequest withLanguage(Language language) {
        tmdbUrl.addLanguage(language.getIsoCode());
        return this;
    }

    public TmdbTvDetailsRequest withAppendedResponse(List<AppendableTvResponse> appendableTvResponses) {
        tmdbUrl.addAppendToResponse(constructAppendableTvResponses(appendableTvResponses));
        return this;
    }

    @Override
    public TvDetails fetch() {
        URL url = tmdbUrl.build();
        return tmdbHttpClient.fetch(url, TvDetails.class);
    }

    @Override
    protected TmdbTvDetailsRequest thisInstance() {
        return this;
    }

    private String constructAppendableTvResponses(List<AppendableTvResponse> appendableTvResponses) {
        return appendableTvResponses.stream()
                .filter(Objects::nonNull)
                .map(AppendableTvResponse::getValue)
                .collect(Collectors.joining(","));
    }

}
