package com.cinemadice.tmdbapi.model.tv;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Season {

    private int id;
    @SerializedName("air_date")
    private String airDate;
    @SerializedName("episode_count")
    private int episodeCount;
    private String name;
    private String overview;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("season_number")
    private int seasonNumber;

}
