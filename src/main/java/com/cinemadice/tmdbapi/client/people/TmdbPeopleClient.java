package com.cinemadice.tmdbapi.client.people;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.url.people.PersonDetailsUrl;

public class TmdbPeopleClient {

    private final TmdbHttpClient tmdbHttpClient;

    public TmdbPeopleClient(TmdbHttpClient tmdbHttpClient) {
        if (tmdbHttpClient == null) {
            throw new IllegalArgumentException(
                    "TmdbHttpClient has to be initialized in TmdbClient with a valid Access Token");
        }
        this.tmdbHttpClient = tmdbHttpClient;
    }

    public TmdbPersonDetailsRequest detailsOf(int personId) {
        return new TmdbPersonDetailsRequest(new PersonDetailsUrl(personId), tmdbHttpClient);
    }

}
