package com.cinemadice.tmdbapi.model.movies;

import com.cinemadice.tmdbapi.model.Genre;
import com.cinemadice.tmdbapi.model.ProductionCompany;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;

@Data
public class MovieDetails extends CommonMovieDetails {

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

}
