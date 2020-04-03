package com.cinemadice.tmdbapi.client.people;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TmdbPeopleClientTest {

    private TmdbPeopleClient tmdbPeopleClient;

    @Mock
    private TmdbHttpClient tmdbHttpClient;

    @BeforeEach
    public void setUp() {
        tmdbPeopleClient = new TmdbPeopleClient(tmdbHttpClient);
    }

    @Test
    public void shouldThrowExceptionGivenNull() {
        assertThrows(IllegalArgumentException.class, () -> new TmdbPeopleClient(null));
    }

    @Test
    public void shouldInitializePersonDetailsRequest() {
        TmdbPersonDetailsRequest result = tmdbPeopleClient.detailsOf(1);
        assertNotNull(result);
    }

}
