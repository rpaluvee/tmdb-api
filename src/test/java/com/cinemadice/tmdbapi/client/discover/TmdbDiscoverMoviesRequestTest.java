package com.cinemadice.tmdbapi.client.discover;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.model.discover.DiscoverMovies;
import com.cinemadice.tmdbapi.url.MovieGenre;
import com.cinemadice.tmdbapi.url.discover.DiscoverMoviesUrl;
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
class TmdbDiscoverMoviesRequestTest {

    private TmdbDiscoverMoviesRequest tmdbDiscoverMoviesRequest;

    @Mock
    private TmdbHttpClient tmdbHttpClient;

    @BeforeEach
    public void setUp() {
        tmdbDiscoverMoviesRequest = new TmdbDiscoverMoviesRequest(new DiscoverMoviesUrl(), tmdbHttpClient);
    }

    @Test
    public void shouldFetchGivenNoParameters() throws MalformedURLException {
        // given
        DiscoverMovies expected = new DiscoverMovies();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/discover/movie?");
        when(tmdbHttpClient.fetch(expectedUrl, DiscoverMovies.class)).thenReturn(expected);

        // when
        DiscoverMovies actual = tmdbDiscoverMoviesRequest.fetch();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFetchGivenSomeParameters() throws MalformedURLException {
        // given
        DiscoverMovies expected = new DiscoverMovies();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/discover/movie?"
                + "primary_release_year=2020&"
                + "language=test&"
                + "sort_by=test&"
                + "page=1");
        when(tmdbHttpClient.fetch(expectedUrl, DiscoverMovies.class)).thenReturn(expected);

        // when
        DiscoverMovies actual = tmdbDiscoverMoviesRequest
                .withPrimaryReleaseYear(2020)
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
        DiscoverMovies expected = new DiscoverMovies();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/discover/movie?"
                + "include_adult=true&"
                + "include_video=true&"
                + "region=test&"
                + "primary_release_year=2020&"
                + "with_cast=test&"
                + "certification=test&"
                + "certification_country=test&"
                + "certification.gte=test&"
                + "certification.lte=test&"
                + "with_crew=test&"
                + "with_people=test&"
                + "primary_release_date.gte=test&"
                + "primary_release_date.lte=test&"
                + "release_date.gte=test&"
                + "release_date.lte=test&"
                + "with_release_type=1&"
                + "with_companies=test&"
                + "with_genres=12%2C80&"
                + "with_keywords=test&"
                + "with_original_language=test&"
                + "without_genres=12%2C80&"
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
        when(tmdbHttpClient.fetch(expectedUrl, DiscoverMovies.class)).thenReturn(expected);

        // when
        List<MovieGenre> movieGenres = new ArrayList<>();
        movieGenres.add(MovieGenre.ADVENTURE);
        movieGenres.add(MovieGenre.CRIME);

        DiscoverMovies actual = tmdbDiscoverMoviesRequest
                .includeAdult(true)
                .includeVideo(true)
                .withRegion("test")
                .withPrimaryReleaseYear(2020)
                .withCast("test")
                .withCertification("test")
                .withCertificationCountry("test")
                .withCertificationGreaterThanOrEqual("test")
                .withCertificationLessThanOrEqual("test")
                .withCrew("test")
                .withPeople("test")
                .withPrimaryReleaseDateGreaterThanOrEqual("test")
                .withPrimaryReleaseDateLessThanOrEqual("test")
                .withReleaseDateGreaterThanOrEqual("test")
                .withReleaseDateLessThanOrEqual("test")
                .withReleaseType(1)
                .withCompanies("test")
                .withGenres(movieGenres)
                .withKeywords("test")
                .withOriginalLanguage("test")
                .withoutGenres(movieGenres)
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
