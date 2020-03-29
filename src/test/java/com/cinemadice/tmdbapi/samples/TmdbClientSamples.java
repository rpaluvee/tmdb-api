package com.cinemadice.tmdbapi.samples;

import com.cinemadice.tmdbapi.client.TmdbClient;
import com.cinemadice.tmdbapi.model.discover.DiscoverMovies;
import com.cinemadice.tmdbapi.model.discover.DiscoverTv;
import com.cinemadice.tmdbapi.model.movies.Movie;
import com.cinemadice.tmdbapi.model.movies.MovieDetails;
import com.cinemadice.tmdbapi.model.movies.UpcomingMovies;
import com.cinemadice.tmdbapi.model.tv.TvAiringToday;
import com.cinemadice.tmdbapi.model.tv.TvDetails;
import com.cinemadice.tmdbapi.model.tv.TvSeries;
import com.cinemadice.tmdbapi.url.MovieGenre;
import com.cinemadice.tmdbapi.url.TvGenre;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TmdbClientSamples {

    private static final String ACCESS_TOKEN = "<ACCESS_TOKEN>";

    private static TmdbClient tmdbClient;

    @BeforeAll
    static void setUp() {
        tmdbClient = new TmdbClient(ACCESS_TOKEN);
    }

    @Test
    public void discoverSomeMovies() {
        List<MovieGenre> movieGenres = new ArrayList<>();
        movieGenres.add(MovieGenre.ACTION);
        movieGenres.add(MovieGenre.ADVENTURE);

        DiscoverMovies discoverMovies = tmdbClient.discover().movies()
                .withGenres(movieGenres)
                .withLanguage("en-US")
                .withPrimaryReleaseYear(2018)
                .withPage(2)
                .fetch();
        List<Movie> movies = discoverMovies.getResults();
        movies.forEach(movie -> System.out.println(movie.getTitle() + " (year: " + movie.getReleaseDate() + ")"));
    }

    @Test
    public void fetchSomeUpcomingMovies() {
        UpcomingMovies upcomingMovies = tmdbClient.movies().upcomingInTheatres()
                .withLanguage("en-US")
                .withRegion("US")
                .withPage(2)
                .fetch();
        List<Movie> movies = upcomingMovies.getResults();
        movies.forEach(um -> System.out.println(um.getTitle() + " (year: " + um.getReleaseDate() + ")"));
    }

    @Test
    public void fetchAdditionalDetailsAboutAMovie() {
        MovieDetails movieDetails = tmdbClient.movies().detailsOf(490132).fetch();
        System.out.println(movieDetails);
    }

    @Test
    public void discoverSomeTvShows() {
        List<TvGenre> tvGenres = new ArrayList<>();
        tvGenres.add(TvGenre.CRIME);
        tvGenres.add(TvGenre.MYSTERY);

        DiscoverTv discoverTv = tmdbClient.discover().tv()
                .withGenres(tvGenres)
                .withLanguage("en-US")
                .withPage(2)
                .fetch();
        List<TvSeries> tv = discoverTv.getResults();
        tv.forEach(tvSeries -> System.out.println(tvSeries.getName() + " (year: " + tvSeries.getFirstAirDate() + ")"));
    }

    @Test
    public void fetchTvShowsAiringToday() {
        TvAiringToday tvAiringToday = tmdbClient.tv().airingToday()
                .withLanguage("en-US")
                .withPage(2)
                .fetch();
        List<TvSeries> tvSeries = tvAiringToday.getResults();
        tvSeries.forEach(tvShow ->
                System.out.println(tvShow.getName() + " (year: " + tvShow.getFirstAirDate() + ")"));
    }

    @Test
    public void fetchAdditionalDetailsAboutATvShow() {
        TvDetails tvDetails = tmdbClient.tv().detailsOf(1399).fetch();
        System.out.println(tvDetails);
    }

}
