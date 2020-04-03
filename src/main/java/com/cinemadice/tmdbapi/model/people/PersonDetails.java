package com.cinemadice.tmdbapi.model.people;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class PersonDetails {

    private int id;
    private String birthday;
    private String deathday;
    @SerializedName("known_for_department")
    private String knownForDepartment;
    private String name;
    @SerializedName("also_known_as")
    private List<String> alsoKnownAs;
    private int gender;
    private String biography;
    private double popularity;
    @SerializedName("place_of_birth")
    private String placeOfBirth;
    @SerializedName("profile_path")
    private String profilePath;
    private boolean adult;
    @SerializedName("imdb_id")
    private String imdbId;
    private String homepage;

    // Appendable details
    private PersonImages images;

}
