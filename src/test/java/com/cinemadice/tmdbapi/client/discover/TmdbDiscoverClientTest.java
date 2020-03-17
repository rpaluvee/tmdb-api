package com.cinemadice.tmdbapi.client.discover;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TmdbDiscoverClientTest {

    private TmdbDiscoverClient tmdbDiscoverClient;

    @Mock
    private TmdbHttpClient tmdbHttpClient;

    @BeforeEach
    public void setUp() {
        tmdbDiscoverClient = new TmdbDiscoverClient(tmdbHttpClient);
    }

    @Test
    public void shouldThrowExceptionGivenNull() {
        assertThrows(IllegalArgumentException.class, () -> new TmdbDiscoverClient(null));
    }

    @Test
    public void shouldInitializeMoviesRequest() {
        TmdbDiscoverMoviesRequest result = tmdbDiscoverClient.movies();
        assertNotNull(result);
    }

    @Test
    public void shouldInitializeTvRequest() {
        TmdbDiscoverTvRequest result = tmdbDiscoverClient.tv();
        assertNotNull(result);
    }

}
