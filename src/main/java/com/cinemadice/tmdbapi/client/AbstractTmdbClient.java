package com.cinemadice.tmdbapi.client;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;

abstract class AbstractTmdbClient {

    private final String apiKey;

    AbstractTmdbClient(String apiKey) {
        this.apiKey = apiKey;
    }

    <T> T deserializeJson(InputStreamReader reader, Class<T> clazz) {
        return new Gson().fromJson(reader, clazz);
    }

    InputStreamReader readUrl(TmdbUrl tmdbUrl) {
        try {
            tmdbUrl.addParameter(TmdbParameter.API_KEY, apiKey);
            return new InputStreamReader(tmdbUrl.buildUrl().openStream());
        } catch (IOException e) {
            // TODO: think bout it
            throw new RuntimeException(e);
        }
    }

}
