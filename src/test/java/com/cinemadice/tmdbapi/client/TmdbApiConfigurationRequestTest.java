package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.model.TmdbApiConfiguration;
import com.cinemadice.tmdbapi.url.ConfigurationUrl;
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
public class TmdbApiConfigurationRequestTest {

    private TmdbApiConfigurationRequest tmdbApiConfigurationRequest;

    @Mock
    private TmdbHttpClient tmdbHttpClient;

    @BeforeEach
    public void setUp() {
        tmdbApiConfigurationRequest = new TmdbApiConfigurationRequest(new ConfigurationUrl(), tmdbHttpClient);
    }

    @Test
    public void shouldFetch() throws MalformedURLException {
        // given
        TmdbApiConfiguration expected = new TmdbApiConfiguration();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/configuration?");
        when(tmdbHttpClient.fetch(expectedUrl, TmdbApiConfiguration.class)).thenReturn(expected);

        // when
        TmdbApiConfiguration actual = tmdbApiConfigurationRequest.fetch();

        // then
        assertEquals(expected, actual);
    }

}
