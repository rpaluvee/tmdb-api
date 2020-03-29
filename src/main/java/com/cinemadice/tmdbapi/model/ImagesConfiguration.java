package com.cinemadice.tmdbapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ImagesConfiguration {

    @SerializedName("base_url")
    private String baseUrl;
    @SerializedName("secure_base_url")
    private String secureBaseUrl;
    @SerializedName("backdrop_sizes")
    private List<String> backdropSizes;
    @SerializedName("logo_sizes")
    private List<String> logoSizes;
    @SerializedName("poster_sizes")
    private List<String> posterSizes;
    @SerializedName("profile_sizes")
    private List<String> profileSizes;
    @SerializedName("still_sizes")
    private List<String> stillSizes;

}
