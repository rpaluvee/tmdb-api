package com.cinemadice.tmdbapi.client.tv;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TmdbTvClientTest {

    private TmdbTvClient tmdbTvClient;

    @Mock
    private TmdbHttpClient tmdbHttpClient;

    @BeforeEach
    public void setUp() {
        tmdbTvClient = new TmdbTvClient(tmdbHttpClient);
    }

    @Test
    public void throwsExceptionWhenGivenNull() {
        assertThrows(IllegalArgumentException.class, () -> new TmdbTvClient(null));
    }

    @Test
    public void initializesAiringTodayRequest() {
        TmdbTvAiringTodayRequest result = tmdbTvClient.airingToday();
        assertNotNull(result);
    }

    @Test
    public void initializesTvDetailsRequest() {
        TmdbTvDetailsRequest result = tmdbTvClient.detailsOf(1);
        assertNotNull(result);
    }

}
