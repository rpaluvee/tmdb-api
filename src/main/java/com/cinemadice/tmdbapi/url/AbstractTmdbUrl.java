package com.cinemadice.tmdbapi.url;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractTmdbUrl {

    private static final String API_VERSION = "3";
    private static final String BASE_URL = "https://api.themoviedb.org/" + API_VERSION;

    protected final Map<TmdbParameter, String> tmdbParameters = new LinkedHashMap<>();
    private final String endpoint;

    protected AbstractTmdbUrl(Endpoint endpoint) {
        this.endpoint = endpoint.getUrl();
    }

    // TODO: Should make filling the placeholders more dynamic when multiple variables occur in endpoint url
    protected AbstractTmdbUrl(Endpoint endpoint, EndpointPlaceholder placeholder, String value) {
        this.endpoint = endpoint.getUrl().replace(placeholder.getValue(), value);
    }

    public void addLanguage(String language) {
        tmdbParameters.put(TmdbParameter.LANGUAGE, String.valueOf(language));
    }

    public URL build() {
        try {
            URL url = new URL(BASE_URL + endpoint + "?" + buildQueryComponent());
            return url;
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
