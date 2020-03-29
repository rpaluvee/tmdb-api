package com.cinemadice.tmdbapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class TmdbApiConfiguration {

    @SerializedName("images")
    private ImagesConfiguration imagesConfiguration;
    @SerializedName("change_keys")
    private List<String> changeKeys;

}
