package com.cinemadice.tmdbapi.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Discover {

    private int page;
    private int total_results;
    private int total_pages;
    private ArrayList<Movie> results;

}
