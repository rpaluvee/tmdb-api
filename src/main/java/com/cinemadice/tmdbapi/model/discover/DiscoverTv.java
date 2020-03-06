package com.cinemadice.tmdbapi.model.discover;

import com.cinemadice.tmdbapi.model.tv.TvSeries;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class DiscoverTv {

    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    private List<TvSeries> results;

}
