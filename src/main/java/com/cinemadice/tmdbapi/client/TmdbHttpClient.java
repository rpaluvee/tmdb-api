package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.exception.FailedTmdbRequestException;
import com.cinemadice.tmdbapi.model.ErrorResponse;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class TmdbHttpClient {

    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();

    private final Headers headers;

    TmdbHttpClient(String accessToken) {
        headers = new Headers.Builder()
                .add("Authorization", "Bearer " + accessToken)
                .add("Content-Type", "application/json;charset=utf-8")
                .build();
    }

    public <T> T fetch(URL url, Class<T> clazz) {
        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .build();

        return readResponse(url, request, clazz);
    }

    private <T> T readResponse(URL url, Request request, Class<T> clazz) {
        try (Response response = OK_HTTP_CLIENT.newCall(request).execute()) {
            String responseBody = Objects.requireNonNull(response.body()).string();
            if (response.isSuccessful()) {
                return fromJson(responseBody, clazz);
            } else {
                ErrorResponse errorResponse = fromJson(responseBody, ErrorResponse.class);
                throw new FailedTmdbRequestException(response.code(), response.message(),
                        errorResponse.getStatusMessage());
            }
        } catch (IOException e) {
            throw new FailedTmdbRequestException("Connection could not be established with URL: " + url, e);
        }
    }

    private <T> T fromJson(String response, Class<T> clazz) {
        try {
            return new Gson().fromJson(response, clazz);
        } catch (JsonSyntaxException e) {
            throw new FailedTmdbRequestException(
                    "Response body received from TMDb API contains "
                            + "JSON syntax errors and can't be deserialized to JSON", e);
        }
    }

}
