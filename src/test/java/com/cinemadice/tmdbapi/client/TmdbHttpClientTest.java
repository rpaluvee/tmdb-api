package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.model.discover.DiscoverMovies;
import com.cinemadice.tmdbapi.model.movies.Movie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TmdbHttpClientTest {

    private static final String ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyY2JiNWE1OWI4MmM2NmI5YTJjZjRjN2U3MTQ"
            + "0MmZkYiIsInN1YiI6IjVkZjJiZjk3MmNkZTk4MDAxNjMwMmZhZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.t"
            + "xGfDomDajnMlr_YlcpJoztrSlDAAlA2VAXizQGJy5A";

    private TmdbHttpClient tmdbHttpClient = new TmdbHttpClient(ACCESS_TOKEN);
    private MockWebServer server;
    private Headers headers;

    @BeforeEach
    public void setUp() throws IOException {
        headers = new Headers.Builder()
                .add("Authorization", "Bearer " + ACCESS_TOKEN)
                .add("Content-Type", "application/json;charset=utf-8")
                .build();

        server = new MockWebServer();
        server.start();
    }

    @AfterEach
    public void tearDown() throws IOException {
        server.shutdown();
    }

    @Test
    public void shouldFetchGivenDiscoverMoviesEndpoint() {
        // when
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

        HttpUrl serverUrl = server.url("/3/discover/movie?");
        MockResponse mockResponse = new MockResponse()
                .setHeaders(headers)
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(ResourceFileReader.readJson("discover_movies_response.json"));
        server.enqueue(mockResponse);

        // given
        DiscoverMovies actual = tmdbHttpClient.fetch(serverUrl.url(), DiscoverMovies.class);

        // then
        assertEquals(expected, actual);
    }

}