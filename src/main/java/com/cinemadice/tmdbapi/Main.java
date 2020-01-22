package com.cinemadice.tmdbapi;

import com.cinemadice.tmdbapi.methods.TmdbMovies;

public class Main {

    // Example of use
    public static void main(String[] args) {
        TmdbApi tmdbApi = new TmdbApi("2cbb5a59b82c66b9a2cf4c7e71442fdb");
        TmdbMovies tmdbMovies = tmdbApi.getTmdbMovies();

        System.out.println(tmdbMovies.fetchRandomMovie());
        System.out.println(tmdbMovies.fetchAllMovies());
    }

}
