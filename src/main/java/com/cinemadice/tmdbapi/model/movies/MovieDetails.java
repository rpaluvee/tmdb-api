package com.cinemadice.tmdbapi.model.movies;

import com.cinemadice.tmdbapi.model.Credits;
import com.cinemadice.tmdbapi.model.Genre;
import com.cinemadice.tmdbapi.model.ProductionCompany;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class MovieDetails {

    // General details
    private int id;
    private String title;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("vote_average")
    private double voteAverage;
    private float popularity;
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

    // Additional details
    @SerializedName("belongs_to_collection")
    private Object belongsToCollection;
    private int budget;
    private List<Genre> genres;
    private String homepage;
    @SerializedName("imdb_id")
    private String imdbId;
    @SerializedName("production_companies")
    private List<ProductionCompany> productionCompanies;
    @SerializedName("production_countries")
    private List<ProductionCountry> productionCountries;
    private int revenue;
    private int runtime;
    @SerializedName("spoken_languages")
    private List<SpokenLanguage> spokenLanguages;
    private String status;
    private String tagline;

    // Appendable details
    private Credits credits;

}
