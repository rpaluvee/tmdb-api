package com.cinemadice.tmdbapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;

@Data
public class DiscoverTv {

    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    private List<TvSeries> results;

}
