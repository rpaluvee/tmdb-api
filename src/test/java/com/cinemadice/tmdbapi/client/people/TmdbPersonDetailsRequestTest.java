package com.cinemadice.tmdbapi.client.people;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.filter.Language;
import com.cinemadice.tmdbapi.model.people.PersonDetails;
import com.cinemadice.tmdbapi.url.people.PersonDetailsUrl;
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
public class TmdbPersonDetailsRequestTest {

    private TmdbPersonDetailsRequest tmdbPersonDetailsRequest;

    @Mock
    private TmdbHttpClient tmdbHttpClient;

    @BeforeEach
    public void setUp() {
        tmdbPersonDetailsRequest = new TmdbPersonDetailsRequest(new PersonDetailsUrl(1), tmdbHttpClient);
    }

    @Test
    public void shouldFetchGivenNoParameters() throws MalformedURLException {
        // given
        PersonDetails expected = new PersonDetails();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/person/1?");
        when(tmdbHttpClient.fetch(expectedUrl, PersonDetails.class)).thenReturn(expected);

        // when
        PersonDetails actual = tmdbPersonDetailsRequest.fetch();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFetchGivenAllParameters() throws MalformedURLException {
        // given
        PersonDetails expected = new PersonDetails();
        URL expectedUrl = new URL("https://api.themoviedb.org/3/person/1?language=en&append_to_response=images");
        when(tmdbHttpClient.fetch(expectedUrl, PersonDetails.class)).thenReturn(expected);

        // when
        PersonDetails actual = tmdbPersonDetailsRequest
                .withLanguage(Language.ENGLISH)
                .withAppendedResponse(Arrays.asList(AppendablePersonResponse.IMAGES))
                .fetch();

        // then
        assertEquals(expected, actual);
    }

}
