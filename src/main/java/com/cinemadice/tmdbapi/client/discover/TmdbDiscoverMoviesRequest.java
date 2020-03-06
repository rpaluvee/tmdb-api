package com.cinemadice.tmdbapi.client.discover;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.model.discover.DiscoverMovies;
import com.cinemadice.tmdbapi.model.movies.Movie;
import com.cinemadice.tmdbapi.url.discover.DiscoverMoviesUrl;

import java.net.URL;
import java.util.List;

public class TmdbDiscoverMoviesRequest extends
        AbstractTmdbDiscoverRequest<TmdbDiscoverMoviesRequest, DiscoverMoviesUrl> {

    TmdbDiscoverMoviesRequest(DiscoverMoviesUrl discoverMoviesUrl, TmdbHttpClient tmdbHttpClient) {
        super(discoverMoviesUrl, tmdbHttpClient);
    }

    public TmdbDiscoverMoviesRequest withRegion(String region) {
        tmdbUrl.addRegion(region);
        return this;
    }

    public TmdbDiscoverMoviesRequest withCertificationCountry(String certificationCountry) {
        tmdbUrl.addCertificationCountry(certificationCountry);
        return this;
    }

    public TmdbDiscoverMoviesRequest withCertification(String certification) {
        tmdbUrl.addCertification(certification);
        return this;
    }

    public TmdbDiscoverMoviesRequest withCertificationLessThanOrEqual(String certification) {
        tmdbUrl.addCertificationLessThanOrEqual(certification);
        return this;
    }

    public TmdbDiscoverMoviesRequest withCertificationGreaterThanOrEqual(String certification) {
        tmdbUrl.addCertificationGreaterThanOrEqual(certification);
        return this;
    }

    public TmdbDiscoverMoviesRequest includeAdult(boolean isAdult) {
        tmdbUrl.addIncludeAdult(isAdult);
        return this;
    }

    public TmdbDiscoverMoviesRequest includeVideo(boolean isVideo) {
        tmdbUrl.addIncludeVideo(isVideo);
        return this;
    }

    public TmdbDiscoverMoviesRequest withPrimaryReleaseYear(int year) {
        tmdbUrl.addPrimaryReleaseYear(year);
        return this;
    }

    public TmdbDiscoverMoviesRequest withPrimaryReleaseDateLessThanOrEqual(String primaryReleaseDate) {
        tmdbUrl.addPrimaryReleaseDateLessThanOrEqual(primaryReleaseDate);
        return this;
    }

    public TmdbDiscoverMoviesRequest withPrimaryReleaseDateGreaterThanOrEqual(String primaryReleaseDate) {
        tmdbUrl.addPrimaryReleaseDateGreaterThanOrEqual(primaryReleaseDate);
        return this;
    }

    public TmdbDiscoverMoviesRequest withReleaseDateLessThanOrEqual(String releaseDate) {
        tmdbUrl.addReleaseDateLessThanOrEqual(releaseDate);
        return this;
    }

    public TmdbDiscoverMoviesRequest withReleaseDateGreaterThanOrEqual(String releaseDate) {
        tmdbUrl.addReleaseDateGreaterThanOrEqual(releaseDate);
        return this;
    }

    public TmdbDiscoverMoviesRequest withReleaseType(int releaseType) {
        tmdbUrl.addWithReleaseType(releaseType);
        return this;
    }

    public TmdbDiscoverMoviesRequest withCast(String cast) {
        tmdbUrl.addWithCast(cast);
        return this;
    }

    public TmdbDiscoverMoviesRequest withCrew(String crew) {
        tmdbUrl.addWithCrew(crew);
        return this;
    }

    public TmdbDiscoverMoviesRequest withPeople(String people) {
        tmdbUrl.addWithPeople(people);
        return this;
    }

    @Override
    public List<Movie> fetch() {
        URL url = tmdbUrl.build();
        DiscoverMovies discoverMovies = tmdbHttpClient.fetch(url, DiscoverMovies.class);
        return discoverMovies.getResults();
    }

    @Override
    protected TmdbDiscoverMoviesRequest thisInstance() {
        return this;
    }

}
