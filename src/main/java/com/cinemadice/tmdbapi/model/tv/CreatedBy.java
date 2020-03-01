package com.cinemadice.tmdbapi.model.tv;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CreatedBy {

    private int id;
    @SerializedName("credit_id")
    private String creditId;
    private String name;
    private int gender;
    @SerializedName("profile_path")
    private String profilePath;

}
