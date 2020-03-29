package com.cinemadice.tmdbapi.client.discover;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.model.discover.DiscoverTv;
import com.cinemadice.tmdbapi.url.TvGenre;
import com.cinemadice.tmdbapi.url.discover.DiscoverTvUrl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TmdbDiscoverTvRequestTest {

    private TmdbDiscoverTvRequest tmdbDiscoverTvRequest;

    @Mock
    private TmdbHttpClient tmdbHttpClient;

    @BeforeEach
    public void setUp() {
        tmdbDiscoverTvRequest = new TmdbDiscoverTvRequest(new DiscoverTvUrl(), tmdbHttpClient);
    }

    @Test
    public void shouldFetchGivenNoParameters() throws MalformedURLException {
        // given
        DiscoverTv expected = new DiscoverTv();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/discover/tv?");
        when(tmdbHttpClient.fetch(expectedUrl, DiscoverTv.class)).thenReturn(expected);

        // when
        DiscoverTv actual = tmdbDiscoverTvRequest.fetch();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFetchGivenSomeParameters() throws MalformedURLException {
        // given
        DiscoverTv expected = new DiscoverTv();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/discover/tv?"
                + "first_air_date_year=2020&"
                + "language=test&"
                + "sort_by=test&"
                + "page=1");
        when(tmdbHttpClient.fetch(expectedUrl, DiscoverTv.class)).thenReturn(expected);

        // when
        DiscoverTv actual = tmdbDiscoverTvRequest
                .withFirstAirDateYear(2020)
                .withLanguage("test")
                .withSort("test")
                .withPage(1)
                .fetch();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFetchGivenAllParameters() throws MalformedURLException {
        // given
        DiscoverTv expected = new DiscoverTv();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/discover/tv?"
                + "screened_theatrically=true&"
                + "include_null_first_air_dates=true&"
                + "air_date.gte=test&"
                + "air_date.lte=test&"
                + "first_air_date.gte=test&"
                + "first_air_date.lte=test&"
                + "first_air_date_year=2020&"
                + "with_networks=test&"
                + "timezone=test&"
                + "with_companies=test&"
                + "with_genres=10759%2C10766&"
                + "with_keywords=test&"
                + "with_original_language=test&"
                + "without_genres=10759%2C10766&"
                + "without_keywords=test&"
                + "page=1&"
                + "with_runtime.gte=1&"
                + "with_runtime.lte=1&"
                + "sort_by=test&"
                + "vote_average.gte=1&"
                + "vote_average.lte=1&"
                + "vote_count.gte=1&"
                + "vote_count.lte=1&"
                + "language=test");
        when(tmdbHttpClient.fetch(expectedUrl, DiscoverTv.class)).thenReturn(expected);

        // when
        List<TvGenre> tvGenres = new ArrayList<>();
        tvGenres.add(TvGenre.ACTION_AND_ADVENTURE);
        tvGenres.add(TvGenre.SOAP);

        DiscoverTv actual = tmdbDiscoverTvRequest
                .screenedTheatrically(true)
                .includeNullFirstAirDates(true)
                .withAirDateGreaterThanOrEqual("test")
                .withAirDateLessThanOrEqual("test")
                .withFirstAirDateGreaterThanOrEqual("test")
                .withFirstAirDateLessThanOrEqual("test")
                .withFirstAirDateYear(2020)
                .withNetworks("test")
                .withTimezone("test")
                .withCompanies("test")
                .withGenres(tvGenres)
                .withKeywords("test")
                .withOriginalLanguage("test")
                .withoutGenres(tvGenres)
                .withoutKeywords("test")
                .withPage(1)
                .withRuntimeGreaterThanOrEqual(1)
                .withRuntimeLessThanOrEqual(1)
                .withSort("test")
                .withVoteAverageGreaterThanOrEqual(1)
                .withVoteAverageLessThanOrEqual(1)
                .withVoteCountGreaterThanOrEqual(1)
                .withVoteCountLessThanOrEqual(1)
                .withLanguage("test")
                .fetch();

        // then
        assertEquals(expected, actual);
    }

}
