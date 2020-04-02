package com.cinemadice.tmdbapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Video {

    private String id;
    @SerializedName("iso_639_1")
    private String languageIso;
    @SerializedName("iso_3166_1")
    private String regionIso;
    private String key;
    private String name;
    private String site;
    private int size;
    private String type;

}
