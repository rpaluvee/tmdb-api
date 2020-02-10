package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.exception.FailedTmdbRequestException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

final class Utils {

    private Utils() {}

    static <T> T fromJson(String response, Class<T> clazz) {
        try {
            return new Gson().fromJson(response, clazz);
        } catch (JsonSyntaxException e) {
            throw new FailedTmdbRequestException(
                    "Response body received from TMDb API contains JSON syntax errors and can't be deserialized to JSON", e);
        }
    }

}
