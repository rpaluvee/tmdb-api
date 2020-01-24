package com.cinemadice.tmdbapi;

import com.cinemadice.tmdbapi.methods.TmdbMovies;

// Example of use
public class Main {

    private static final String API_KEY = "2cbb5a59b82c66b9a2cf4c7e71442fdb";

    public static void main(String[] args) {
        TmdbApi tmdbApi = new TmdbApi(API_KEY);
        TmdbMovies tmdbMovies = tmdbApi.getTmdbMovies();

        System.out.println(tmdbMovies.fetchRandomMovie());
        System.out.println(tmdbMovies.fetchAllMovies());
    }

}
