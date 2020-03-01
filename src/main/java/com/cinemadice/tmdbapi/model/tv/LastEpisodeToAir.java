package com.cinemadice.tmdbapi.model.tv;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LastEpisodeToAir {

    private int id;
    @SerializedName("air_date")
    private String airDate;
    @SerializedName("episode_number")
    private int episodeNumber;
    private String name;
    private String overview;
    @SerializedName("production_code")
    private String productionCode;
    @SerializedName("season_number")
    private int seasonNumber;
    @SerializedName("show_id")
    private int showId;
    @SerializedName("still_path")
    private String stillPath;
    @SerializedName("vote_average")
    protected double voteAverage;
    @SerializedName("vote_count")
    protected int voteCount;

}
