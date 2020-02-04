package com.cinemadice.tmdbapi.client;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO: should rename this to something else
abstract class AbstractTmdbClient {

    private static Logger LOGGER = Logger.getLogger(AbstractTmdbClient.class.toString());

    <T> T fromJson(Reader reader, Class<T> clazz) {
        return new Gson().fromJson(reader, clazz);
    }

    Reader readUrl(URL url) {
        try {
            return new InputStreamReader(url.openStream());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE,"Connection could not be established with URL: " + url.toString());
            throw new RuntimeException(e);
        }
    }

}
