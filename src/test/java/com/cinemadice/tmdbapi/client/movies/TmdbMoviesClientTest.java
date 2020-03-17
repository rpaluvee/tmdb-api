package com.cinemadice.tmdbapi.client.movies;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TmdbMoviesClientTest {

    private TmdbMoviesClient tmdbMoviesClient;

    @Mock
    private TmdbHttpClient tmdbHttpClient;

    @BeforeEach
    public void setUp() {
        tmdbMoviesClient = new TmdbMoviesClient(tmdbHttpClient);
    }

    @Test
    public void shouldThrowExceptionGivenNull() {
        assertThrows(IllegalArgumentException.class, () -> new TmdbMoviesClient(null));
    }

    @Test
    public void shouldInitializeUpcomingMoviesRequest() {
        TmdbUpcomingMoviesRequest result = tmdbMoviesClient.upcomingInTheatres();
        assertNotNull(result);
    }

    @Test
    public void shouldInitializeMovieDetailsRequest() {
        TmdbMovieDetailsRequest result = tmdbMoviesClient.detailsOf(1);
        assertNotNull(result);
    }

}
