package com.cinemadice.tmdbapi.samples;

import com.cinemadice.tmdbapi.client.TmdbClient;
import com.cinemadice.tmdbapi.model.discover.DiscoverMovies;
import com.cinemadice.tmdbapi.model.discover.DiscoverTv;
import com.cinemadice.tmdbapi.model.movies.Movie;
import com.cinemadice.tmdbapi.model.movies.MovieDetails;
import com.cinemadice.tmdbapi.model.tv.TvDetails;
import com.cinemadice.tmdbapi.model.tv.TvSeries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

@Disabled
public class TmdbClientSamples {

    private static final String ACCESS_TOKEN = "<ACCESS_TOKEN>";

    private static TmdbClient tmdbClient;

    @BeforeAll
    static void setUp() {
        tmdbClient = new TmdbClient(ACCESS_TOKEN);
    }

    @Test
    public void discoverSomeMovies() {
        DiscoverMovies discoverMovies = tmdbClient.discover().movies()
                .withLanguage("en-US")
                .withPrimaryReleaseYear(2018)
                .withPage(2)
                .fetch();
        List<Movie> movies = discoverMovies.getResults();
        movies.forEach(movie -> System.out.println(movie.getTitle() + " (year: " + movie.getReleaseDate() + ")"));
    }

    @Test
    public void fetchSomeUpcomingMovies() {
        List<Movie> upcomingMovies = tmdbClient.movies().upcomingInTheatres()
                .withLanguage("en-US")
                .withRegion("US")
                .withPage(2)
                .fetch();
        upcomingMovies.forEach(um -> System.out.println(um.getTitle() + " (year: " + um.getReleaseDate() + ")"));
    }

    @Test
    public void fetchAdditionalDetailsAboutAMovie() {
        MovieDetails movieDetails = tmdbClient.movies().detailsOf(490132).fetch();
        System.out.println(movieDetails);
    }

    @Test
    public void discoverSomeTvShows() {
        DiscoverTv discoverTv = tmdbClient.discover().tv()
                .withLanguage("en-US")
                .withPage(2)
                .fetch();
        List<TvSeries> tv = discoverTv.getResults();
        tv.forEach(tvSeries -> System.out.println(tvSeries.getName() + " (year: " + tvSeries.getFirstAirDate() + ")"));
    }

    @Test
    public void fetchTvShowsAiringToday() {
        List<TvSeries> tvAiringToday = tmdbClient.tv().airingToday()
                .withLanguage("en-US")
                .withPage(2)
                .fetch();
        tvAiringToday.forEach(tvShow ->
                System.out.println(tvShow.getName() + " (year: " + tvShow.getFirstAirDate() + ")"));
    }

    @Test
    public void fetchAdditionalDetailsAboutATvShow() {
        TvDetails tvDetails = tmdbClient.tv().detailsOf(1399).fetch();
        System.out.println(tvDetails);
    }

}
