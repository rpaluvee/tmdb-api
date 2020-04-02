package com.cinemadice.tmdbapi.model.movies;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Movie {

    private int id;
    private String title;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("vote_average")
    private double voteAverage;
    private double popularity;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("poster_path")
    private String posterPath;
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;
    private boolean video;
    private boolean adult;

    @SerializedName("genre_ids")
    private List<Integer> genreIds;

}
