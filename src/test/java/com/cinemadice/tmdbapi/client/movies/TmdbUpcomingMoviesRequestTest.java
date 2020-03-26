package com.cinemadice.tmdbapi.client.movies;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.model.movies.UpcomingMovies;
import com.cinemadice.tmdbapi.url.movies.UpcomingMoviesUrl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TmdbUpcomingMoviesRequestTest {

    private TmdbUpcomingMoviesRequest tmdbUpcomingMoviesRequest;

    @Mock
    private TmdbHttpClient tmdbHttpClient;

    @BeforeEach
    public void setUp() {
        tmdbUpcomingMoviesRequest = new TmdbUpcomingMoviesRequest(new UpcomingMoviesUrl(), tmdbHttpClient);
    }

    @Test
    public void shouldFetchGivenNoParameters() throws MalformedURLException {
        // given
        UpcomingMovies expected = new UpcomingMovies();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/movie/upcoming?");
        when(tmdbHttpClient.fetch(expectedUrl, UpcomingMovies.class)).thenReturn(expected);

        // when
        UpcomingMovies actual = tmdbUpcomingMoviesRequest.fetch();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFetchGivenSomeParameters() throws MalformedURLException {
        // given
        UpcomingMovies expected = new UpcomingMovies();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/movie/upcoming?"
                + "region=test&"
                + "language=test");
        when(tmdbHttpClient.fetch(expectedUrl, UpcomingMovies.class)).thenReturn(expected);

        // when
        UpcomingMovies actual = tmdbUpcomingMoviesRequest
                .withRegion("test")
                .withLanguage("test")
                .fetch();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFetchGivenAllParameters() throws MalformedURLException {
        // given
        UpcomingMovies expected = new UpcomingMovies();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/movie/upcoming?"
                + "region=test&"
                + "page=1&"
                + "language=test");
        when(tmdbHttpClient.fetch(expectedUrl, UpcomingMovies.class)).thenReturn(expected);

        // when
        UpcomingMovies actual = tmdbUpcomingMoviesRequest
                .withRegion("test")
                .withPage(1)
                .withLanguage("test")
                .fetch();

        // then
        assertEquals(expected, actual);
    }

}
