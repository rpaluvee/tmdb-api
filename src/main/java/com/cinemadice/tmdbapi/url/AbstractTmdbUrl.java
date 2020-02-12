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
        try {
            return new URL(BASE_URL + endpoint.getEndpointUrl() + "?" + buildQueryComponent());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String buildQueryComponent() {
        List<String> params = new ArrayList<>();
        tmdbParameters.forEach((k, v) -> params.add(urlEncode(k.getValue()) + "=" + urlEncode(v)));
        return String.join("&", params);
    }

    private static String urlEncode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
