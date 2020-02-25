package com.cinemadice.tmdbapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SpokenLanguage {

    @SerializedName("iso_639_1")
    private String iso;
    private String name;

}
