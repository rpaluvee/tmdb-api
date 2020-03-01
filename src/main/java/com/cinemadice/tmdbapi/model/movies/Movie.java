package com.cinemadice.tmdbapi.model.movies;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;

@Data
public class Movie extends MovieDetails {

    @SerializedName("genre_ids")
    private List<Integer> genreIds;

}
