package com.cinemadice.tmdbapi.url;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class TmdbUrl {

    private static final String BASE_URL = "https://api.themoviedb.org/3";

    private final Map<TmdbParameter, String> tmdbParameters = new HashMap<>();

    public TmdbUrl(String apiKey) {
        tmdbParameters.put(TmdbParameter.API_KEY, apiKey);
    }

    public DiscoverMoviesUrl discoverMovies() {
        return new DiscoverMoviesUrl(this);
    }

    URL buildUrl(Endpoint endpoint) {
        URL url = null;
        try {
            url = new URL(BASE_URL + endpoint.getEndpointUrl() + "?" + buildQueryComponent(tmdbParameters));
        } catch (MalformedURLException e) {
            // TODO: always use Logger instead of stacktrace
            e.printStackTrace();
        }
        return url;
    }

    void addParameter(TmdbParameter tmdbParameter, String value) {
        tmdbParameters.put(tmdbParameter, value);
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
