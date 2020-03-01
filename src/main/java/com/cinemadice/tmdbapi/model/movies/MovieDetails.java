package com.cinemadice.tmdbapi.model.movies;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
class MovieDetails {

    protected int id;
    protected String title;
    @SerializedName("original_title")
    protected String originalTitle;
    @SerializedName("vote_count")
    protected int voteCount;
    @SerializedName("vote_average")
    protected double voteAverage;
    protected float popularity;
    @SerializedName("original_language")
    protected String originalLanguage;
    @SerializedName("backdrop_path")
    protected String backdropPath;
    @SerializedName("poster_path")
    protected String posterPath;
    protected String overview;
    @SerializedName("release_date")
    protected String releaseDate;
    protected boolean video;
    protected boolean adult;

}
