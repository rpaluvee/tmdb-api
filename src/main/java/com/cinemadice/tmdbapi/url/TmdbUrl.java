package com.cinemadice.tmdbapi.url;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;

public class TmdbUrl {

    private static final String BASE_URL = "https://api.themoviedb.org/3";

    private final Map<TmdbParameter, String> tmdbParameters;
    private final Endpoint endpoint;

    TmdbUrl(Map<TmdbParameter, String> tmdbParameters, Endpoint endpoint) {
        this.tmdbParameters = Objects.requireNonNull(tmdbParameters);
        this.endpoint = Objects.requireNonNull(endpoint);
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

    public static DiscoverMoviesUrlBuilder discoverMovies() {
        return new DiscoverMoviesUrlBuilder();
    }

}
