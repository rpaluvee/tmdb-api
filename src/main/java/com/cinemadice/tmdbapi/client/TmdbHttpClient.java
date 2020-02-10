package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.exception.FailedTmdbRequestException;
import com.cinemadice.tmdbapi.model.ErrorResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

class TmdbHttpClient {

    private final OkHttpClient client = new OkHttpClient();

    String fetch(URL url) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        return readResponse(url, request);
    }

    private String readResponse(URL url, Request request) {
        try (Response response = client.newCall(request).execute()) {
            String responseBody = Objects.requireNonNull(response.body()).string();
            if (response.isSuccessful()) {
                return responseBody;
            } else {
                ErrorResponse errorResponse = Utils.fromJson(responseBody, ErrorResponse.class);
                throw new FailedTmdbRequestException(response.code(), response.message(), errorResponse.getStatusMessage());
            }
        } catch (IOException e) {
            throw new FailedTmdbRequestException("Connection could not be established with URL: " + url, e);
        }
    }

}
