package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.exception.FailedTmdbRequestException;
import com.cinemadice.tmdbapi.model.TmdbErrorResponse;
import com.cinemadice.tmdbapi.model.discover.DiscoverMovies;
import com.cinemadice.tmdbapi.model.movies.Movie;
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
    public void shouldFetchErrorResponse() {
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
    public void shouldFetchDiscoverMovies() {
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

}
