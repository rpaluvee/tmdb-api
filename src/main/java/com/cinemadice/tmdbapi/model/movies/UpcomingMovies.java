package com.cinemadice.tmdbapi.model.movies;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;

@Data
public class UpcomingMovies {

    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    private List<Movie> results;
    private Object dates;

}
