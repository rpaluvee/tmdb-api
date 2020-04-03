package com.cinemadice.tmdbapi.url.people;

import com.cinemadice.tmdbapi.url.AbstractTmdbUrl;
import com.cinemadice.tmdbapi.url.Endpoint;
import com.cinemadice.tmdbapi.url.EndpointPlaceholder;
import com.cinemadice.tmdbapi.url.TmdbParameter;

public class PersonDetailsUrl extends AbstractTmdbUrl {

    public PersonDetailsUrl(int personId) {
        super(Endpoint.PERSON_DETAILS, EndpointPlaceholder.PERSON_ID, String.valueOf(personId));
    }

    public void addAppendToResponse(String appendedResponse) {
        tmdbParameters.put(TmdbParameter.APPEND_TO_RESPONSE, appendedResponse);
    }

}
