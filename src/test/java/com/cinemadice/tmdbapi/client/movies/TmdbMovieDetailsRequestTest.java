package com.cinemadice.tmdbapi.client.movies;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.filter.Language;
import com.cinemadice.tmdbapi.model.movies.MovieDetails;
import com.cinemadice.tmdbapi.url.movies.MovieDetailsUrl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TmdbMovieDetailsRequestTest {

    private TmdbMovieDetailsRequest tmdbMovieDetailsRequest;

    @Mock
    private TmdbHttpClient tmdbHttpClient;

    @BeforeEach
    public void setUp() {
        tmdbMovieDetailsRequest = new TmdbMovieDetailsRequest(new MovieDetailsUrl(1), tmdbHttpClient);
    }

    @Test
    public void shouldFetchGivenNoParameters() throws MalformedURLException {
        // given
        MovieDetails expected = new MovieDetails();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/movie/1?");
        when(tmdbHttpClient.fetch(expectedUrl, MovieDetails.class)).thenReturn(expected);

        // when
        MovieDetails actual = tmdbMovieDetailsRequest.fetch();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFetchGivenAllParameters() throws MalformedURLException {
        // given
        MovieDetails expected = new MovieDetails();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/movie/1?language=en&append_to_response=credits");
        when(tmdbHttpClient.fetch(expectedUrl, MovieDetails.class)).thenReturn(expected);

        // when
        MovieDetails actual = tmdbMovieDetailsRequest
                .withLanguage(Language.ENGLISH)
                .withAppendedResponse(Arrays.asList(AppendableMovieResponse.CREDITS))
                .fetch();

        // then
        assertEquals(expected, actual);
    }

}
