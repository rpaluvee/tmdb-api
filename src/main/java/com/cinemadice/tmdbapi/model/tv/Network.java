package com.cinemadice.tmdbapi.model.tv;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Network {

    private int id;
    private String name;
    @SerializedName("logo_path")
    private String logoPath;
    @SerializedName("origin_country")
    private String originCountry;

}
