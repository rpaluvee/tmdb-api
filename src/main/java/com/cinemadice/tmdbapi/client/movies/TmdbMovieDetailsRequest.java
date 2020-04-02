package com.cinemadice.tmdbapi.client.movies;

import com.cinemadice.tmdbapi.client.AbstractTmdbRequest;
import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.filter.Language;
import com.cinemadice.tmdbapi.model.movies.MovieDetails;
import com.cinemadice.tmdbapi.url.movies.MovieDetailsUrl;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TmdbMovieDetailsRequest extends AbstractTmdbRequest<TmdbMovieDetailsRequest, MovieDetailsUrl> {

    TmdbMovieDetailsRequest(MovieDetailsUrl movieDetailsUrl, TmdbHttpClient tmdbHttpClient) {
        super(movieDetailsUrl, tmdbHttpClient);
    }

    public TmdbMovieDetailsRequest withLanguage(Language language) {
        tmdbUrl.addLanguage(language.getIsoCode());
        return this;
    }

    public TmdbMovieDetailsRequest withAppendedResponse(List<AppendableMovieResponse> appendableMovieResponses) {
        tmdbUrl.addAppendToResponse(constructAppendableMovieResponses(appendableMovieResponses));
        return this;
    }

    @Override
    public MovieDetails fetch() {
        URL url = tmdbUrl.build();
        return tmdbHttpClient.fetch(url, MovieDetails.class);
    }

    @Override
    protected TmdbMovieDetailsRequest thisInstance() {
        return this;
    }

    private String constructAppendableMovieResponses(List<AppendableMovieResponse> appendableMovieResponses) {
        return appendableMovieResponses.stream()
                .filter(Objects::nonNull)
                .map(AppendableMovieResponse::getValue)
                .collect(Collectors.joining(","));
    }

}
