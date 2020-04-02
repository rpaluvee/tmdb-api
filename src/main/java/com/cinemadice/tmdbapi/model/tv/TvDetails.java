package com.cinemadice.tmdbapi.model.tv;

import com.cinemadice.tmdbapi.model.Credits;
import com.cinemadice.tmdbapi.model.Genre;
import com.cinemadice.tmdbapi.model.ProductionCompany;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class TvDetails {

    // General details
    private int id;
    private String name;
    @SerializedName("original_name")
    private String originalName;
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
    @SerializedName("first_air_date")
    private String firstAirDate;
    @SerializedName("origin_country")
    private List<String> originCountry;

    // Additional details
    @SerializedName("created_by")
    private List<CreatedBy> createdBy;
    @SerializedName("episode_run_time")
    private List<Integer> episodeRunTime;
    private List<Genre> genres;
    private String homepage;
    @SerializedName("in_production")
    private boolean inProduction;
    private List<String> languages;
    @SerializedName("last_air_date")
    private String lastAirDate;
    @SerializedName("last_episode_to_air")
    private LastEpisodeToAir lastEpisodeToAir;
    @SerializedName("next_episode_to_air")
    private Object nextEpisodeToAir;
    private List<Network> networks;
    @SerializedName("number_of_episodes")
    private int numberOfEpisodes;
    @SerializedName("number_of_seasons")
    private int numberOfSeasons;
    @SerializedName("production_companies")
    private List<ProductionCompany> productionCompanies;
    private List<Season> seasons;
    private String status;
    private String type;

    // Appendable details
    private Credits credits;

}
