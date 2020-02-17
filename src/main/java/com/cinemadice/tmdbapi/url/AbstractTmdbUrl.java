package com.cinemadice.tmdbapi.url;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractTmdbUrl {

    private static final String API_VERSION = "4";
    private static final String BASE_URL = "https://api.themoviedb.org/" + API_VERSION;

    protected final Map<TmdbParameter, String> tmdbParameters;
    protected final Endpoint endpoint;

    protected AbstractTmdbUrl(Endpoint endpoint) {
        this.tmdbParameters = new HashMap<>();
        this.endpoint = endpoint;
    }

    public void addLanguage(String language) {
        tmdbParameters.put(TmdbParameter.LANGUAGE, String.valueOf(language));
    }

    public URL build() {
        try {
            return new URL(BASE_URL + endpoint.getEndpointUrl() + "?" + buildQueryComponent());
        } catch (MalformedURLException e) {
            throw new AssertionError(e);
        }
    }

    private String buildQueryComponent() {
        return tmdbParameters.entrySet().stream()
                .map(AbstractTmdbUrl::buildPair)
                .collect(Collectors.joining("&"));
    }

    private static String buildPair(Map.Entry<TmdbParameter, String> entry) {
        return urlEncode(entry.getKey().getValue()) + "=" + urlEncode(entry.getValue());
    }

    private static String urlEncode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("UTF-8 not supported", e);
        }
    }

}
