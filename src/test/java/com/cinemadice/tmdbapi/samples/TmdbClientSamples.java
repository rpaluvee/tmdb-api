package com.cinemadice.tmdbapi.samples;

import com.cinemadice.tmdbapi.Language;
import com.cinemadice.tmdbapi.MovieGenre;
import com.cinemadice.tmdbapi.Region;
import com.cinemadice.tmdbapi.TvGenre;
import com.cinemadice.tmdbapi.client.TmdbClient;
import com.cinemadice.tmdbapi.model.TmdbApiConfiguration;
import com.cinemadice.tmdbapi.model.discover.DiscoverMovies;
import com.cinemadice.tmdbapi.model.discover.DiscoverTv;
import com.cinemadice.tmdbapi.model.movies.Movie;
import com.cinemadice.tmdbapi.model.movies.MovieDetails;
import com.cinemadice.tmdbapi.model.movies.UpcomingMovies;
import com.cinemadice.tmdbapi.model.tv.TvAiringToday;
import com.cinemadice.tmdbapi.model.tv.TvDetails;
import com.cinemadice.tmdbapi.model.tv.TvSeries;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
                .withGenres(Arrays.asList(MovieGenre.ACTION, MovieGenre.COMEDY))
                .withOriginalLanguage(Language.ENGLISH)
                .withPrimaryReleaseYear(2018)
                .withRegion(Region.UNITED_STATES_OF_AMERICA)
                .withPage(2)
                .fetch();
        List<Movie> movies = discoverMovies.getResults();
        movies.forEach(movie -> System.out.println(movie.getTitle() + " (year: " + movie.getReleaseDate() + ")"));
    }

    @Test
    public void fetchSomeUpcomingMovies() {
        UpcomingMovies upcomingMovies = tmdbClient.movies().upcomingInTheatres()
                .withLanguage(Language.ENGLISH)
                .withRegion(Region.UNITED_STATES_OF_AMERICA)
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
        DiscoverTv discoverTv = tmdbClient.discover().tv()
                .withGenres(Arrays.asList(TvGenre.CRIME, TvGenre.MYSTERY))
                .withLanguage(Language.ENGLISH)
                .withPage(2)
                .fetch();
        List<TvSeries> tv = discoverTv.getResults();
        tv.forEach(tvSeries -> System.out.println(tvSeries.getName() + " (year: " + tvSeries.getFirstAirDate() + ")"));
    }

    @Test
    public void fetchTvShowsAiringToday() {
        TvAiringToday tvAiringToday = tmdbClient.tv().airingToday()
                .withLanguage(Language.ENGLISH)
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

    @Test
    public void fetchTmdbApiConfiguration() {
        TmdbApiConfiguration tmdbApiConfiguration = tmdbClient.configuration().fetch();
        System.out.println(tmdbApiConfiguration);
    }

}
