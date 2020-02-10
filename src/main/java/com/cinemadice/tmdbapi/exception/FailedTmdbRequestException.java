package com.cinemadice.tmdbapi.exception;

import lombok.Getter;

@Getter
public class FailedTmdbRequestException extends RuntimeException {

    private int code;
    private String detailedMessage;

    public FailedTmdbRequestException(String message) {
        super(message);
    }

    public FailedTmdbRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedTmdbRequestException(int code, String message, String detailedMessage) {
        super(String.format("TMDb API responded with %s: %s - %s", code, message, detailedMessage));
    }

}
