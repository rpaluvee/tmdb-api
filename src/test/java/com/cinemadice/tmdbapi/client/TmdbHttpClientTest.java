package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.exception.FailedTmdbRequestException;
import com.cinemadice.tmdbapi.model.Genre;
import com.cinemadice.tmdbapi.model.ProductionCompany;
import com.cinemadice.tmdbapi.model.TmdbErrorResponse;
import com.cinemadice.tmdbapi.model.discover.DiscoverMovies;
import com.cinemadice.tmdbapi.model.discover.DiscoverTv;
import com.cinemadice.tmdbapi.model.movies.Dates;
import com.cinemadice.tmdbapi.model.movies.Movie;
import com.cinemadice.tmdbapi.model.movies.MovieDetails;
import com.cinemadice.tmdbapi.model.movies.ProductionCountry;
import com.cinemadice.tmdbapi.model.movies.SpokenLanguage;
import com.cinemadice.tmdbapi.model.movies.UpcomingMovies;
import com.cinemadice.tmdbapi.model.tv.TvSeries;
import com.cinemadice.tmdbapi.url.Endpoint;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class TmdbHttpClientTest {

    private static final String ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyY2JiNWE1OWI4MmM2NmI5YTJjZjRjN2U3MTQ"
            + "0MmZkYiIsInN1YiI6IjVkZjJiZjk3MmNkZTk4MDAxNjMwMmZhasdsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.t"
            + "xGfDomDajnMlr_YlcpJoztrSlDAAlA2VAXizQGJy5A";

    private TmdbHttpClient tmdbHttpClient = new TmdbHttpClient(ACCESS_TOKEN);
    private static MockWebServer server;
    private static Headers headers;

    @BeforeAll
    static void setUp() throws IOException {
        headers = new Headers.Builder()
                .add("Authorization", "Bearer " + ACCESS_TOKEN)
                .add("Content-Type", "application/json;charset=utf-8")
                .build();

        server = new MockWebServer();
        server.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        server.shutdown();
    }

    @Test
    public void shouldThrowExceptionGivenBadJson() {
        // given
        HttpUrl serverUrl = server.url("/some/endpoint");
        MockResponse mockResponse = new MockResponse()
                .setHeaders(headers)
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody("bad_json");
        server.enqueue(mockResponse);

        // then
        assertThrows(FailedTmdbRequestException.class,
                () -> tmdbHttpClient.fetch(serverUrl.url(), TmdbErrorResponse.class));
    }

    @Test
    public void shouldThrowExceptionGivenUnsuccessfulResponse() {
        // given
        HttpUrl serverUrl = server.url("/some/endpoint");
        MockResponse mockResponse = new MockResponse()
                .setHeaders(headers)
                .setResponseCode(HttpURLConnection.HTTP_UNAUTHORIZED)
                .setBody(TestResourceFileReader.readFileContents("unauthorized_response.json"));
        server.enqueue(mockResponse);

        // then
        assertThrows(FailedTmdbRequestException.class,
                () -> tmdbHttpClient.fetch(serverUrl.url(), TmdbErrorResponse.class));
    }

    @Test
    public void shouldFetchErrorResponseGivenUnsuccessfulResponse() {
        // given
        TmdbErrorResponse expected = new TmdbErrorResponse();
        expected.setStatusCode(7);
        expected.setStatusMessage("Invalid API key: You must be granted a valid key.");
        expected.setSuccess(false);

        HttpUrl serverUrl = server.url("/some/endpoint");
        MockResponse mockResponse = new MockResponse()
                .setHeaders(headers)
                .setResponseCode(HttpURLConnection.HTTP_UNAUTHORIZED)
                .setBody(TestResourceFileReader.readFileContents("unauthorized_response.json"));
        server.enqueue(mockResponse);

        try {
            // when
            tmdbHttpClient.fetch(serverUrl.url(), TmdbErrorResponse.class);
            fail();
        } catch (FailedTmdbRequestException e) {
            // then
            assertEquals(expected, e.getTmdbErrorResponse());
        }
    }

    @Test
    public void shouldFetchDiscoverMoviesGivenSuccessfulResponse() {
        // given
        List<Integer> firstMovieGenres = new ArrayList<>();
        firstMovieGenres.add(28);
        firstMovieGenres.add(12);
        firstMovieGenres.add(18);
        firstMovieGenres.add(10751);

        Movie firstMovie = new Movie();
        firstMovie.setPosterPath(null);
        firstMovie.setAdult(false);
        firstMovie.setOverview("Amy is only...");
        firstMovie.setReleaseDate("1996-09-13");
        firstMovie.setGenreIds(firstMovieGenres);
        firstMovie.setId(11076);
        firstMovie.setOriginalTitle("Fly Away Home");
        firstMovie.setOriginalLanguage("en");
        firstMovie.setTitle("Fly Away Home");
        firstMovie.setBackdropPath(null);
        firstMovie.setPopularity(1.022039f);
        firstMovie.setVoteCount(13);
        firstMovie.setVideo(false);
        firstMovie.setVoteAverage(6.69);

        List<Integer> secondMovieGenres = new ArrayList<>();
        secondMovieGenres.add(18);
        secondMovieGenres.add(10749);

        Movie secondMovie = new Movie();
        secondMovie.setPosterPath(null);
        secondMovie.setAdult(false);
        secondMovie.setOverview("With their father away...");
        secondMovie.setReleaseDate("1994-12-21");
        secondMovie.setGenreIds(secondMovieGenres);
        secondMovie.setId(9587);
        secondMovie.setOriginalTitle("Little Women");
        secondMovie.setOriginalLanguage("en");
        secondMovie.setTitle("Little Women");
        secondMovie.setBackdropPath(null);
        secondMovie.setPopularity(1.051359f);
        secondMovie.setVoteCount(50);
        secondMovie.setVideo(false);
        secondMovie.setVoteAverage(6.65);

        List<Movie> movies = new ArrayList<>();
        movies.add(firstMovie);
        movies.add(secondMovie);

        DiscoverMovies expected = new DiscoverMovies();
        expected.setPage(1);
        expected.setTotalResults(61);
        expected.setTotalPages(4);
        expected.setResults(movies);

        HttpUrl serverUrl = server.url(Endpoint.DISCOVER_MOVIE.getUrl());
        MockResponse mockResponse = new MockResponse()
                .setHeaders(headers)
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(TestResourceFileReader.readFileContents("discover_movies_response.json"));
        server.enqueue(mockResponse);

        // when
        DiscoverMovies actual = tmdbHttpClient.fetch(serverUrl.url(), DiscoverMovies.class);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFetchUpcomingMovieGivenSuccessfulResponse() {
        // given
        List<Integer> genres = new ArrayList<>();
        genres.add(18);

        Dates dates = new Dates();
        dates.setMaximum("2016-09-22");
        dates.setMinimum("2016-09-01");

        Movie movie = new Movie();
        movie.setPosterPath("/pEFRzXtLmxYNjGd0XqJDHPDFKB2.jpg");
        movie.setAdult(false);
        movie.setOverview("A lighthouse keeper...");
        movie.setReleaseDate("2016-09-02");
        movie.setGenreIds(genres);
        movie.setId(283552);
        movie.setOriginalTitle("The Light Between Oceans");
        movie.setOriginalLanguage("en");
        movie.setTitle("The Light Between Oceans");
        movie.setBackdropPath("/2Ah63TIvVmZM3hzUwR5hXFg2LEk.jpg");
        movie.setPopularity(4.546151f);
        movie.setVoteCount(11);
        movie.setVideo(false);
        movie.setVoteAverage(4.41);

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        UpcomingMovies expected = new UpcomingMovies();
        expected.setPage(1);
        expected.setTotalResults(222);
        expected.setTotalPages(12);
        expected.setResults(movies);
        expected.setDates(dates);

        HttpUrl serverUrl = server.url(Endpoint.UPCOMING_MOVIE.getUrl());
        MockResponse mockResponse = new MockResponse()
                .setHeaders(headers)
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(TestResourceFileReader.readFileContents("upcoming_movies_response.json"));
        server.enqueue(mockResponse);

        // when
        UpcomingMovies actual = tmdbHttpClient.fetch(serverUrl.url(), UpcomingMovies.class);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFetchMovieDetailsGivenSuccessfulResponse() {
        // given
        Genre genre = new Genre();
        genre.setId(18);
        genre.setName("Drama");
        List<Genre> genres = new ArrayList<>();
        genres.add(genre);

        ProductionCompany productionCompany = new ProductionCompany();
        productionCompany.setId(508);
        productionCompany.setLogoPath("/7PzJdsLGlR7oW4J0J5Xcd0pHGRg.png");
        productionCompany.setName("Regency Enterprises");
        productionCompany.setOriginCountry("US");
        List<ProductionCompany> productionCompanies = new ArrayList<>();
        productionCompanies.add(productionCompany);

        ProductionCountry productionCountry = new ProductionCountry();
        productionCountry.setIso("US");
        productionCountry.setName("United States of America");
        List<ProductionCountry> productionCountries = new ArrayList<>();
        productionCountries.add(productionCountry);

        SpokenLanguage spokenLanguage = new SpokenLanguage();
        spokenLanguage.setIso("en");
        spokenLanguage.setName("English");
        List<SpokenLanguage> spokenLanguages = new ArrayList<>();
        spokenLanguages.add(spokenLanguage);

        MovieDetails expected = new MovieDetails();
        expected.setAdult(false);
        expected.setBackdropPath("/fCayJrkfRaCRCTh8GqN30f8oyQF.jpg");
        expected.setBelongsToCollection(null);
        expected.setBudget(63000000);
        expected.setGenres(genres);
        expected.setHomepage("");
        expected.setId(550);
        expected.setImdbId("tt0137523");
        expected.setOriginalLanguage("en");
        expected.setOriginalTitle("Fight Club");
        expected.setOverview("A ticking-time-bomb...");
        expected.setPopularity(0.5f);
        expected.setPosterPath(null);
        expected.setProductionCompanies(productionCompanies);
        expected.setProductionCountries(productionCountries);
        expected.setReleaseDate("1999-10-12");
        expected.setRevenue(100853753);
        expected.setRuntime(139);
        expected.setSpokenLanguages(spokenLanguages);
        expected.setStatus("Released");
        expected.setTagline("How much can...");
        expected.setTitle("Fight Club");
        expected.setVideo(false);
        expected.setVoteAverage(7.8);
        expected.setVoteCount(3439);

        HttpUrl serverUrl = server.url(Endpoint.MOVIE_DETAILS.getUrl());
        MockResponse mockResponse = new MockResponse()
                .setHeaders(headers)
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(TestResourceFileReader.readFileContents("movie_details_response.json"));
        server.enqueue(mockResponse);

        // when
        MovieDetails actual = tmdbHttpClient.fetch(serverUrl.url(), MovieDetails.class);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFetchDiscoverTvGivenSuccessfulResponse() {
        // given
        List<Integer> genres = new ArrayList<>();
        genres.add(28);

        List<String> originCountry = new ArrayList<>();
        originCountry.add("US");

        TvSeries tvSeries = new TvSeries();
        tvSeries.setName("Marvel's Daredevil");
        tvSeries.setOriginalName("Marvel's Daredevil");
        tvSeries.setPosterPath("/dDfjzRicTeVaiysRTwx56aM8bC3.jpg");
        tvSeries.setFirstAirDate("2015-04-10");
        tvSeries.setOverview("Lawyer-by-day Matt Murdock...");
        tvSeries.setGenreIds(genres);
        tvSeries.setOriginCountry(originCountry);
        tvSeries.setId(61889);
        tvSeries.setOriginalLanguage("en");
        tvSeries.setBackdropPath(null);
        tvSeries.setPopularity(5.4f);
        tvSeries.setVoteCount(19);
        tvSeries.setVoteAverage(7.74);

        List<TvSeries> tvSeriesList = new ArrayList<>();
        tvSeriesList.add(tvSeries);

        DiscoverTv expected = new DiscoverTv();
        expected.setPage(1);
        expected.setTotalResults(61470);
        expected.setTotalPages(3074);
        expected.setResults(tvSeriesList);

        HttpUrl serverUrl = server.url(Endpoint.DISCOVER_TV.getUrl());
        MockResponse mockResponse = new MockResponse()
                .setHeaders(headers)
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(TestResourceFileReader.readFileContents("discover_tv_response.json"));
        server.enqueue(mockResponse);

        // when
        DiscoverTv actual = tmdbHttpClient.fetch(serverUrl.url(), DiscoverTv.class);

        // then
        assertEquals(expected, actual);
    }

}
