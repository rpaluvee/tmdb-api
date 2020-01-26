package com.cinemadice.tmdbapi.client;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

class TmdbUrl {

    private static final String BASE_URL = "https://api.themoviedb.org/3";

    private final Endpoint endpoint;
    private Map<TmdbParameter, String> tmdbParameters = new HashMap<>();

    TmdbUrl(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    URL buildUrl() {
        URL url = null;
        try {
            url = new URL(BASE_URL + endpoint.getEndpointUrl() + "?" + buildQueryComponent(tmdbParameters));
        } catch (MalformedURLException e) {
            // TODO: always use Logger instead of stacktrace
            e.printStackTrace();
        }
        return url;
    }

    TmdbUrl addParameter(TmdbParameter tmdbParameter, String value) {
        tmdbParameters.put(tmdbParameter, value);
        return this;
    }

    TmdbUrl addParameters(Map<TmdbParameter, String> tmdbParameters) {
        this.tmdbParameters = tmdbParameters;
        return this;
    }

    Map<TmdbParameter, String> getTmdbParameters() {
        return tmdbParameters;
    }

    private static String buildQueryComponent(Map<TmdbParameter, String> tmdbParameters) {
        StringBuilder result = new StringBuilder();
        tmdbParameters.forEach((k, v) -> {
            try {
                String encodedValue = URLEncoder.encode(v, "UTF-8");
                result.append(k.getValue()).append(encodedValue).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
        return result.toString().substring(0, result.length() - 1); // removes the last "&"
    }

}
