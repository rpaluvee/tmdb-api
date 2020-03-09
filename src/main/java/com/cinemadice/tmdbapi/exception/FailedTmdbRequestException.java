package com.cinemadice.tmdbapi.exception;

import com.cinemadice.tmdbapi.model.ErrorResponse;
import lombok.Getter;

@Getter
public class FailedTmdbRequestException extends RuntimeException {

    private int code;
    private ErrorResponse errorResponse;

    public FailedTmdbRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedTmdbRequestException(int code, String message, ErrorResponse errorResponse) {
        super(String.format("TMDb API responded with %s: %s - %s", code, message, errorResponse.getStatusMessage()));
        this.code = code;
        this.errorResponse = errorResponse;
    }

}
