package com.cinemadice.tmdbapi.model.discover;

import com.cinemadice.tmdbapi.model.movies.Movie;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class DiscoverMovies {

    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    private List<Movie> results;

}
