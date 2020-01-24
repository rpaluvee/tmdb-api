package com.cinemadice.tmdbapi;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class AbstractTmdbApi {

    private final String apiKey;

    protected AbstractTmdbApi(String apiKey) {
        this.apiKey = apiKey;
    }

    protected <T> T deserializeJson(TmdbUrl tmdbUrl, Class<T> clazz) {
        tmdbUrl.addParameter(TmdbParameter.API_KEY, apiKey);
        return new Gson().fromJson(readUrl(tmdbUrl.buildUrl()), clazz);
    }

    private static Reader readUrl(URL url) {
        try {
            return new InputStreamReader(url.openStream());
        } catch (IOException e) {
            // TODO: think bout it
            throw new RuntimeException(e);
        }
    }

}