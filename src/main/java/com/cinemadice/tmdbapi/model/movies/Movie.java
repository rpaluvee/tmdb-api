package com.cinemadice.tmdbapi.model.movies;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Movie extends CommonMovieDetails {

    @SerializedName("genre_ids")
    private List<Integer> genreIds;

}
