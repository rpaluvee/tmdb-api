package com.cinemadice.tmdbapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Crew {

    private int id;
    @SerializedName("credit_id")
    private String creditId;
    private String department;
    private Integer gender;
    private String job;
    private String name;
    @SerializedName("profile_path")
    private String profilePath;

}
