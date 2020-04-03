package com.cinemadice.tmdbapi.model.media;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Backdrop {

    @SerializedName("aspect_ratio")
    private double aspectRatio;
    @SerializedName("file_path")
    private String filePath;
    private int height;
    private int width;
    @SerializedName("iso_639_1")
    private String iso;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("vote_count")
    private int voteCount;

}
