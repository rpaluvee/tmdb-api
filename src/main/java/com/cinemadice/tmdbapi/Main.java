package com.cinemadice.tmdbapi;

import com.cinemadice.tmdbapi.client.TmdbClient;
import com.cinemadice.tmdbapi.model.movies.AdditionalMovieDetails;
import com.cinemadice.tmdbapi.model.movies.Movie;
import com.cinemadice.tmdbapi.model.tv.TvSeries;
import java.util.List;

// Example of use
public class Main {

    private static final String ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyY2JiNWE1OWI4MmM2NmI5YTJjZjRjN2U3MTQ"
            + "0MmZkYiIsInN1YiI6IjVkZjJiZjk3MmNkZTk4MDAxNjMwMmZhZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.t"
            + "xGfDomDajnMlr_YlcpJoztrSlDAAlA2VAXizQGJy5A";

    public static void main(String[] args) {
        TmdbClient tmdbClient = new TmdbClient(ACCESS_TOKEN);

        // --- Movie examples ---
        List<Movie> movies = tmdbClient.discover().movies()
                .withLanguage("en-US")
                .withPrimaryReleaseYear(2018)
                .withPage(2)
                .fetch();

        movies.forEach(movie -> System.out.println(movie.getTitle() + " (year: " + movie.getReleaseDate() + ")"));

        List<Movie> upcomingMovies = tmdbClient.movies().upcomingInTheatres()
                .withLanguage("en-US")
                .withRegion("US")
                .withPage(2)
                .fetch();

        upcomingMovies.forEach(um -> System.out.println(um.getTitle() + " (year: " + um.getReleaseDate() + ")"));

        AdditionalMovieDetails additionalMovieDetails = tmdbClient.movies().detailsOf(490132).fetch();
        System.out.println(additionalMovieDetails);

        // --- TV examples ---
        List<TvSeries> tv = tmdbClient.discover().tv()
                .withLanguage("en-US")
                .withPage(2)
                .fetch();

        tv.forEach(tvSeries -> System.out.println(tvSeries.getName() + " (year: " + tvSeries.getFirstAirDate() + ")"));

    }

}
