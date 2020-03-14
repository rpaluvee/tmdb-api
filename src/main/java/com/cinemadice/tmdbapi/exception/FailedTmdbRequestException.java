package com.cinemadice.tmdbapi.exception;

import com.cinemadice.tmdbapi.model.TmdbErrorResponse;
import lombok.Getter;

@Getter
public class FailedTmdbRequestException extends RuntimeException {

    private int responseStatusCode;
    private String responseStatusMessage;
    private TmdbErrorResponse tmdbErrorResponse;

    public FailedTmdbRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedTmdbRequestException(int responseStatusCode,
                                      String responseStatusMessage,
                                      TmdbErrorResponse tmdbErrorResponse) {
        super(responseStatusMessage);
        this.responseStatusCode = responseStatusCode;
        this.responseStatusMessage = responseStatusMessage;
        this.tmdbErrorResponse = tmdbErrorResponse;
    }

}
