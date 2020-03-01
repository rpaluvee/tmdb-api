package com.cinemadice.tmdbapi.model.tv;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;

@Data
public class TvSeries extends TvDetails {

    @SerializedName("genre_ids")
    private List<Integer> genreIds;

}
