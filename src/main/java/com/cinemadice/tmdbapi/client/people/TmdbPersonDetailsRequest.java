package com.cinemadice.tmdbapi.client.people;

import com.cinemadice.tmdbapi.client.AbstractTmdbRequest;
import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.filter.Language;
import com.cinemadice.tmdbapi.model.people.PersonDetails;
import com.cinemadice.tmdbapi.url.people.PersonDetailsUrl;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TmdbPersonDetailsRequest extends AbstractTmdbRequest<TmdbPersonDetailsRequest, PersonDetailsUrl> {

    TmdbPersonDetailsRequest(PersonDetailsUrl personDetailsUrl, TmdbHttpClient tmdbHttpClient) {
        super(personDetailsUrl, tmdbHttpClient);
    }

    public TmdbPersonDetailsRequest withLanguage(Language language) {
        tmdbUrl.addLanguage(language.getIsoCode());
        return this;
    }

    public TmdbPersonDetailsRequest withAppendedResponse(List<AppendablePersonResponse> appendablePersonResponses) {
        tmdbUrl.addAppendToResponse(constructAppendablePersonResponses(appendablePersonResponses));
        return this;
    }

    @Override
    public PersonDetails fetch() {
        URL url = tmdbUrl.build();
        return tmdbHttpClient.fetch(url, PersonDetails.class);
    }

    @Override
    protected TmdbPersonDetailsRequest thisInstance() {
        return this;
    }

    private String constructAppendablePersonResponses(List<AppendablePersonResponse> appendablePersonResponses) {
        return appendablePersonResponses.stream()
                .filter(Objects::nonNull)
                .map(AppendablePersonResponse::getValue)
                .collect(Collectors.joining(","));
    }

}
