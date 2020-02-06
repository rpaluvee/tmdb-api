package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.exception.FailedTmdbRequestException;
import com.cinemadice.tmdbapi.exception.FailedTmdbResponseException;
import lombok.SneakyThrows;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

class TmdbConnectionManager {

    private final HttpsURLConnection https;

    private TmdbConnectionManager(HttpsURLConnection https) {
        this.https = https;
    }

    static TmdbConnectionManager openConnection(URL url) {
        try {
            HttpsURLConnection https = (HttpsURLConnection) url.openConnection();
            return new TmdbConnectionManager(https);
        } catch (IOException e) {
            throw new FailedTmdbRequestException("Connection could not be established with URL: " + url.toString());
        }
    }

    @SneakyThrows //Impossible to have IOException here because we handle it while initializing the connection
    Reader readResponse() {
        int responseCode = https.getResponseCode();
        String responseMessage = https.getResponseMessage();

        if (responseCode == HTTP_OK) {
            return new InputStreamReader(https.getInputStream());
        } else if (responseCode == HTTP_UNAUTHORIZED) {
            throw new FailedTmdbResponseException(responseCode, responseMessage, "TMDb API key is invalid");
        }
        else {
            throw new FailedTmdbResponseException(responseCode, responseMessage);
        }
    }

    // TODO: Validator for API response
    class ResponseValidator {
        boolean isOk() {
            return false;
        }
    }

}
