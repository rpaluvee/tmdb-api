package com.cinemadice.tmdbapi;

import com.cinemadice.tmdbapi.client.TmdbClient;
import com.cinemadice.tmdbapi.model.Movie;
import java.util.List;

// Example of use
public class Main {

    private static final String API_KEY = "2cbb5a59b82c66b9a2cf4c7e71442fdb";

    public static void main(String[] args) {
        TmdbClient tmdbClient = new TmdbClient(API_KEY);

        List<Movie> movies = tmdbClient.movies()
                .withPrimaryReleaseYear(2018)
                .withPage(2)
                .fetch();

        movies.forEach(s -> System.out.println(s.getTitle() + " (year: " + s.getReleaseDate() + ")"));
    }

}
