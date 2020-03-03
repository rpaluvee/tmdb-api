package com.cinemadice.tmdbapi.client.discover;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.url.TmdbParameter;
import com.cinemadice.tmdbapi.url.discover.DiscoverMoviesUrl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class TmdbDiscoverMoviesRequestTest {

    private TmdbHttpClient mockTmdbHttpClient;

    @BeforeEach
    public void setUp() {
        mockTmdbHttpClient = mock(TmdbHttpClient.class);
    }

    @Test
    public void addsRegionParameterToUrl() {
        // given
        DiscoverMoviesUrl discoverMoviesUrl = new DiscoverMoviesUrl();
        TmdbDiscoverMoviesRequest tmdbDiscoverMoviesRequest =
                new TmdbDiscoverMoviesRequest(discoverMoviesUrl, mockTmdbHttpClient);

        // when
        tmdbDiscoverMoviesRequest.withRegion("US");

        // then
        URL url = discoverMoviesUrl.build();
        assertTrue(url.toString().contains(TmdbParameter.REGION.getValue()));
    }

}
