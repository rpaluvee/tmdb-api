package com.cinemadice.tmdbapi.model;

import lombok.Data;

import java.util.List;

@Data
public class Movie {

    private int id;
    private double vote_count;
    private double vote_average;
    private float popularity;
    private String title;
    private String release_date;
    private String original_language;
    private String original_title;
    private String overview;
    private String poster_path;
    private String backdrop_path;
    private boolean video;
    private boolean adult;
    private List<Double> genre_ids;

}
