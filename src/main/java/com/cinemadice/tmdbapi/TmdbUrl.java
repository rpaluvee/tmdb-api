package com.cinemadice.tmdbapi;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TmdbUrl {

    private static final String BASE_URL = "https://api.themoviedb.org/3";

    private final Endpoint endpoint;
    private Map<TmdbParameter, String> tmdbParameters = new HashMap<>();

    public TmdbUrl(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    public URL buildUrl() {
        URL url = null;
        try {
            url = new URL(BASE_URL + endpoint.getEndpointUrl() + "?" + concatParameters(tmdbParameters));
        } catch (MalformedURLException e) {
            // TODO: always use Logger instead of stacktrace
            e.printStackTrace();
        }
        return url;
    }

    public TmdbUrl addParameter(TmdbParameter tmdbParameter, String value) {
        tmdbParameters.put(tmdbParameter, value);
        return this;
    }

    public TmdbUrl addParameters(Map<TmdbParameter, String> tmdbParameters) {
        this.tmdbParameters = tmdbParameters;
        return this;
    }

    public Map<TmdbParameter, String> getTmdbParameters() {
        return tmdbParameters;
    }

    private static String concatParameters(Map<TmdbParameter, String> tmdbParameter) {
        StringBuilder result = new StringBuilder();
        tmdbParameter.forEach((k, v) -> result.append(k.getValue()).append(v).append("&"));
        return result.toString().substring(0, result.length() - 1); // removes the last "&"
    }

}