package com.cinemadice.tmdbapi.model.tv;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class TvSeries extends CommonTvDetails {

    @SerializedName("genre_ids")
    private List<Integer> genreIds;

}
