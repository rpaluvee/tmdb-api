package com.cinemadice.tmdbapi.client.tv;

import com.cinemadice.tmdbapi.Language;
import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.model.tv.TvAiringToday;
import com.cinemadice.tmdbapi.model.tv.TvSeries;
import com.cinemadice.tmdbapi.url.tv.TvAiringTodayUrl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TmdbTvAiringTodayRequestTest {

    private TmdbTvAiringTodayRequest tmdbTvAiringTodayRequest;

    @Mock
    private TmdbHttpClient tmdbHttpClient;

    @BeforeEach
    public void setUp() {
        tmdbTvAiringTodayRequest = new TmdbTvAiringTodayRequest(new TvAiringTodayUrl(), tmdbHttpClient);
    }

    @Test
    public void shouldFetchGivenNoParameters() throws MalformedURLException {
        // given
        TvAiringToday expected = new TvAiringToday();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/tv/airing_today?");
        when(tmdbHttpClient.fetch(expectedUrl, TvAiringToday.class)).thenReturn(expected);

        // when
        TvAiringToday actual = tmdbTvAiringTodayRequest.fetch();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFetchGivenAllParameters() throws MalformedURLException {
        // given
        TvAiringToday expected = new TvAiringToday();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/tv/airing_today?page=1&language=en");
        when(tmdbHttpClient.fetch(expectedUrl, TvAiringToday.class)).thenReturn(expected);

        // when
        TvAiringToday actual = tmdbTvAiringTodayRequest
                .withPage(1)
                .withLanguage(Language.ENGLISH)
                .fetch();

        // then
        assertEquals(expected, actual);
    }

}
