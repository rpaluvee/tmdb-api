package com.cinemadice.tmdbapi.model.media;

import lombok.Data;

import java.util.List;

@Data
public class Videos {

    private int id;
    private List<Video> results;

}
