package com.cinemadice.tmdbapi.model.tv;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class CommonTvDetails {

    protected int id;
    protected String name;
    @SerializedName("original_name")
    protected String originalName;
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
    @SerializedName("first_air_date")
    protected String firstAirDate;
    @SerializedName("origin_country")
    protected List<String> originCountry;

}
