package com.cinemadice.tmdbapi.exception;

public class FailedTmdbResponseException extends RuntimeException {

    public FailedTmdbResponseException(int code, String message) {
        super(constructMessage(code, message));
    }

    public FailedTmdbResponseException(int code, String message, String detailedMessage) {
        super(constructMessage(code, message) + " - " + detailedMessage);
    }

    private static String constructMessage(int code, String message) {
        return String.format("TMDb API responded with %s: %s", code, message);
    }

}
