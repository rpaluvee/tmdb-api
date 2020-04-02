package com.cinemadice.tmdbapi.model;

import lombok.Data;

import java.util.List;

@Data
public class Videos {

    private int id;
    private List<Video> results;

}
