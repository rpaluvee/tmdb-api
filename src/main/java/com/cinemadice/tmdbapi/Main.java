package com.cinemadice.tmdbapi;

import com.cinemadice.tmdbapi.client.TmdbClient;
import com.cinemadice.tmdbapi.model.Movie;
import java.util.List;

// Example of use
public class Main {

    private static final String ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyY2JiNWE1OWI4MmM2NmI5YTJjZjRjN2U3MTQ"
            + "0MmZkYiIsInN1YiI6IjVkZjJiZjk3MmNkZTk4MDAxNjMwMmZhZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.t"
            + "xGfDomDajnMlr_YlcpJoztrSlDAAlA2VAXizQGJy5A";

    public static void main(String[] args) {
        TmdbClient tmdbClient = new TmdbClient(ACCESS_TOKEN);

        List<Movie> movies = tmdbClient.movies()
                .withLanguage("en")
                .withPrimaryReleaseYear(2018)
                .withPage(2)
                .fetch();

        movies.forEach(movie -> System.out.println(movie.getTitle() + " (year: " + movie.getReleaseDate() + ")"));
    }

}
