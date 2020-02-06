package com.cinemadice.tmdbapi.exception;

public class FailedTmdbRequestException extends RuntimeException {

    public FailedTmdbRequestException(String message) {
        super(message);
    }

}
