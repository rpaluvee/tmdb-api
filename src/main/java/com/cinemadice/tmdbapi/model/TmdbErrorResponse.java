package com.cinemadice.tmdbapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class TmdbErrorResponse {

    @SerializedName("status_code")
    private int statusCode;
    @SerializedName("status_message")
    private String statusMessage;
    private boolean success;

}
