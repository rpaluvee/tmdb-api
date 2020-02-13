package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.exception.FailedTmdbRequestException;
import com.cinemadice.tmdbapi.model.ErrorResponse;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class TmdbHttpClient {

    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();

    private final Headers headers;

    TmdbHttpClient(String accessToken) {
        headers = Headers.of(constructHeaders(accessToken));
    }

    String fetch(URL url) {
        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .build();

        return readResponse(url, request);
    }

    private String readResponse(URL url, Request request) {
        try (Response response = OK_HTTP_CLIENT.newCall(request).execute()) {
            String responseBody = Objects.requireNonNull(response.body()).string();
            if (response.isSuccessful()) {
                return responseBody;
            } else {
                ErrorResponse errorResponse = Utils.fromJson(responseBody, ErrorResponse.class);
                throw new FailedTmdbRequestException(response.code(), response.message(),
                        errorResponse.getStatusMessage());
            }
        } catch (IOException e) {
            throw new FailedTmdbRequestException("Connection could not be established with URL: " + url, e);
        }
    }

    private Map<String, String> constructHeaders(String accessToken) {
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put("Authorization", "Bearer " + accessToken);
        headersMap.put("Content-Type", "application/json;charset=utf-8");
        return headersMap;
    }

}
