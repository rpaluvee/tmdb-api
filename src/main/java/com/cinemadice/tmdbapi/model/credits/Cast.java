package com.cinemadice.tmdbapi.model.credits;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Cast {

    private int id;
    @SerializedName("cast_id")
    private int castId;
    private String character;
    @SerializedName("credit_id")
    private String creditId;
    private Integer gender;
    private String name;
    private int order;
    @SerializedName("profile_path")
    private String profilePath;

}
