package com.cinemadice.tmdbapi;

import com.cinemadice.tmdbapi.client.TmdbClient;
import com.cinemadice.tmdbapi.model.Movie;

import java.util.List;

// Example of use
public class Main {

    private static final String API_KEY = "2cbb5a59b82c66b9a2cf4c7e71442fdb";

    public static void main(String[] args) {
        TmdbClient tmdbClient = new TmdbClient(API_KEY);

        List<Movie> movies = tmdbClient.movies().filter()
                .withPrimaryReleaseYear(2018)
                .withPage(2)
                .fetch();

        movies.forEach(s -> System.out.println(s.getTitle() + " (year: " + s.getReleaseDate() + ")"));

        // gimme 5 random movies
        for (int i = 0; i < 5; i++) {
            Movie randomMovie = tmdbClient.movies().fetchRandom();
            System.out.println("Random movie: " + randomMovie.getTitle() + " (year: " + randomMovie.getReleaseDate() + ")");
        }

        // gimme a random movie released in 2008
        int year = 2008;
        Movie randomMovieOfYear = tmdbClient.movies().filter()
                .withPrimaryReleaseYear(year)
                .fetchRandom();
        System.out.println("Random movie released in " + year + ": " + randomMovieOfYear.getTitle() + " (year: " + randomMovieOfYear.getReleaseDate() + ")");
    }

}
