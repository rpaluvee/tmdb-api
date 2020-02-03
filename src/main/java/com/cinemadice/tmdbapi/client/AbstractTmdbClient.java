package com.cinemadice.tmdbapi.client;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

// TODO: should rename this to something else
abstract class AbstractTmdbClient {

    <T> T fromJson(Reader reader, Class<T> clazz) {
        return new Gson().fromJson(reader, clazz);
    }

    Reader readUrl(URL url) {
        try {
            return new InputStreamReader(url.openStream());
        } catch (IOException e) {
            // TODO: think bout it
            throw new RuntimeException(e);
        }
    }

}
