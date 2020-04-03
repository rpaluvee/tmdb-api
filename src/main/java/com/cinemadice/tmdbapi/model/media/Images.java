package com.cinemadice.tmdbapi.model.media;

import lombok.Data;

import java.util.List;

@Data
public class Images {

    private int id;
    private List<Backdrop> backdrops;
    private List<Poster> posters;

}
