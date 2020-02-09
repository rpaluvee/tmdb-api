package com.cinemadice.tmdbapi.url;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractTmdbUrl {

    private static final String BASE_URL = "https://api.themoviedb.org/3";

    protected final Map<TmdbParameter, String> tmdbParameters = new HashMap<>();
    protected Endpoint endpoint;
    protected String apiKey;

    public URL build() {
        tmdbParameters.put(TmdbParameter.API_KEY, apiKey);
        URL url = null;
        try {
            url = new URL(BASE_URL + endpoint.getEndpointUrl() + "?" + buildQueryComponent());
        } catch (MalformedURLException e) {
            // TODO: always use Logger instead of stacktrace
            e.printStackTrace();
        }
        return url;
    }

    private String buildQueryComponent() {
        List<String> params = new ArrayList<>();
        tmdbParameters.forEach((k, v) -> {
            try {
                String encodedValue = URLEncoder.encode(v, StandardCharsets.UTF_8.name());
                params.add(k.getValue() + encodedValue);
            } catch (UnsupportedEncodingException e) {
                // should not happen
                throw new RuntimeException(e);
            }
        });
        return String.join("&", params);
    }

}
