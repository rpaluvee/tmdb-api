package com.cinemadice.tmdbapi.client.tv;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.model.tv.TvDetails;
import com.cinemadice.tmdbapi.url.tv.TvDetailsUrl;
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
public class TmdbTvDetailsRequestTest {

    TmdbTvDetailsRequest tmdbTvDetailsRequest;

    @Mock
    TmdbHttpClient tmdbHttpClient;

    @BeforeEach
    public void setUp() {
        tmdbTvDetailsRequest = new TmdbTvDetailsRequest(new TvDetailsUrl(1), tmdbHttpClient);
    }

    @Test
    public void fetchesWithNoParameters() throws MalformedURLException {
        // given
        TvDetails expected = new TvDetails();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/tv/1?");
        when(tmdbHttpClient.fetch(expectedUrl, TvDetails.class)).thenReturn(expected);

        // when
        TvDetails actual = tmdbTvDetailsRequest.fetch();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void fetchesWithAllParameters() throws MalformedURLException {
        // given
        TvDetails expected = new TvDetails();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/tv/1?language=test");
        when(tmdbHttpClient.fetch(expectedUrl, TvDetails.class)).thenReturn(expected);

        // when
        TvDetails actual = tmdbTvDetailsRequest
                .withLanguage("test")
                .fetch();

        // then
        assertEquals(expected, actual);
    }

}
