package com.cinemadice.tmdbapi.model.movies;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ProductionCountry {

    @SerializedName("iso_3166_1")
    private String iso;
    private String name;

}
