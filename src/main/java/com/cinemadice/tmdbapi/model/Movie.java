package com.cinemadice.tmdbapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;

@Data
public class Movie {

    private int id;
    @SerializedName("vote_count")
    private double voteCount;
    @SerializedName("vote_average")
    private double voteAverage;
    private float popularity;
    private String title;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    private String overview;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("backdrop_path")
    private String backdropPath;
    private boolean video;
    private boolean adult;
    @SerializedName("genre_ids")
    private List<Double> genreIds;

}
