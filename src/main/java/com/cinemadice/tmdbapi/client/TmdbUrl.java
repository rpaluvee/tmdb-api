package com.cinemadice.tmdbapi.client;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

class TmdbUrl {

    private static final String BASE_URL = "https://api.themoviedb.org/3";
    private static final Map<TmdbParameter, String> TMDB_PARAMETERS = new HashMap<>();

    TmdbUrl(String apiKey) {
        TMDB_PARAMETERS.put(TmdbParameter.API_KEY, apiKey);
    }

    URL buildUrl(Endpoint endpoint) {
        URL url = null;
        try {
            url = new URL(BASE_URL + endpoint.getEndpointUrl() + "?" + buildQueryComponent(TMDB_PARAMETERS));
        } catch (MalformedURLException e) {
            // TODO: always use Logger instead of stacktrace
            e.printStackTrace();
        }
        return url;
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

    TmdbUrl addParameter(TmdbParameter tmdbParameter, String value) {
        TMDB_PARAMETERS.put(tmdbParameter, value);
        return this;
    }

    DiscoverMoviesUrl discoverMovies() {
        return new DiscoverMoviesUrl(this);
    }

}
