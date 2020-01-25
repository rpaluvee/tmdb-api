package com.cinemadice.tmdbapi;

import com.cinemadice.tmdbapi.api.TmdbApi;
import com.cinemadice.tmdbapi.model.Movie;

import java.util.List;

// Example of use
public class Main {

    private static final String API_KEY = "2cbb5a59b82c66b9a2cf4c7e71442fdb";

    public static void main(String[] args) {
        TmdbApi tmdbApi = new TmdbApi(API_KEY);

        Movie randomMovie = tmdbApi.movies().fetchRandomMovie();
        List<Movie> allMovies = tmdbApi.movies().fetchAllMovies();

        System.out.println(randomMovie);
        System.out.println(allMovies);
    }

}
