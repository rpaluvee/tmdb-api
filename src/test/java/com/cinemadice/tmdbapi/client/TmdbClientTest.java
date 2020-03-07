package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.client.discover.TmdbDiscoverClient;
import com.cinemadice.tmdbapi.client.movies.TmdbMoviesClient;
import com.cinemadice.tmdbapi.client.tv.TmdbTvClient;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TmdbClientTest {

    private static final String ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyY2JiNWE1OWI4MmM2NmI5YTJjZjRjN2U3MTQ"
            + "0MmZkYiIsInN1YiI6IjVkZjJiZjk3MmNkZTk4MDAxNjMwMmZhZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.t"
            + "xGfDomDajnMlr_YlcpJoztrSlDAAlA2VAXizQGJy5A";

    private TmdbClient tmdbClient = new TmdbClient(ACCESS_TOKEN);

    @Test
    public void throwsExceptionWhenAccessTokenIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new TmdbClient(null));
    }

    @Test
    public void throwsExceptionWhenAccessTokenIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new TmdbClient(""));
    }

    @Test
    public void returnsDiscoverClient() {
        TmdbDiscoverClient result = tmdbClient.discover();
        assertNotNull(result);
    }

    @Test
    public void returnsMoviesClient() {
        TmdbMoviesClient result = tmdbClient.movies();
        assertNotNull(result);
    }

    @Test
    public void returnsTvClient() {
        TmdbTvClient result = tmdbClient.tv();
        assertNotNull(result);
    }

    // Testing lazy initialization of feature client classes
    @Nested
    class WhenClientsInstantiated {

        @Mock
        private TmdbDiscoverClient tmdbDiscoverClient;
        @Mock
        private TmdbMoviesClient tmdbMoviesClient;
        @Mock
        private TmdbTvClient tmdbTvClient;

        @InjectMocks
        private TmdbClient tmdbClient = new TmdbClient(ACCESS_TOKEN);

        @Test
        public void returnsDiscoverClient() {
            TmdbDiscoverClient result = tmdbClient.discover();
            assertNotNull(result);
        }

        @Test
        public void returnsMoviesClient() {
            TmdbMoviesClient result = tmdbClient.movies();
            assertNotNull(result);
        }

        @Test
        public void returnsTvClient() {
            TmdbTvClient result = tmdbClient.tv();
            assertNotNull(result);
        }
    }

}
