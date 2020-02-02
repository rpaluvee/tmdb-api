package com.cinemadice.tmdbapi.url;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractTmdbUrlBuilder {

    private static final String BASE_URL = "https://api.themoviedb.org/3";

    protected final Map<TmdbParameter, String> tmdbParameters = new HashMap<>();
    protected Endpoint endpoint;
    protected String apiKey;

    public URL build() {
        tmdbParameters.put(TmdbParameter.API_KEY, apiKey);
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

}
