package com.cinemadice.tmdbapi.client.discover;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.model.discover.DiscoverTv;
import com.cinemadice.tmdbapi.url.TvGenre;
import com.cinemadice.tmdbapi.url.discover.DiscoverTvUrl;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class TmdbDiscoverTvRequest extends AbstractTmdbDiscoverRequest<TmdbDiscoverTvRequest, DiscoverTvUrl> {

    TmdbDiscoverTvRequest(DiscoverTvUrl discoverTvUrl, TmdbHttpClient tmdbHttpClient) {
        super(discoverTvUrl, tmdbHttpClient);
    }

    public TmdbDiscoverTvRequest withAirDateLessThanOrEqual(String airDate) {
        tmdbUrl.addAirDateLessThanOrEqual(airDate);
        return this;
    }

    public TmdbDiscoverTvRequest withAirDateGreaterThanOrEqual(String airDate) {
        tmdbUrl.addAirDateGreaterThanOrEqual(airDate);
        return this;
    }

    public TmdbDiscoverTvRequest withFirstAirDateLessThanOrEqual(String firstAirDate) {
        tmdbUrl.addFirstAirDateLessThanOrEqual(firstAirDate);
        return this;
    }

    public TmdbDiscoverTvRequest withFirstAirDateGreaterThanOrEqual(String firstAirDate) {
        tmdbUrl.addFirstAirDateGreaterThanOrEqual(firstAirDate);
        return this;
    }

    public TmdbDiscoverTvRequest withFirstAirDateYear(int firstAirDateYear) {
        tmdbUrl.addFirstAirDateYear(firstAirDateYear);
        return this;
    }

    public TmdbDiscoverTvRequest withTimezone(String timezone) {
        tmdbUrl.addTimezone(timezone);
        return this;
    }

    public TmdbDiscoverTvRequest withNetworks(String networks) {
        tmdbUrl.addWithNetworks(networks);
        return this;
    }

    public TmdbDiscoverTvRequest includeNullFirstAirDates(boolean hasAirDate) {
        tmdbUrl.addIncludeNullFirstAirDates(hasAirDate);
        return this;
    }

    public TmdbDiscoverTvRequest screenedTheatrically(boolean hasScreenedTheatrically) {
        tmdbUrl.addScreenedTheatrically(hasScreenedTheatrically);
        return this;
    }

    public TmdbDiscoverTvRequest withGenres(List<TvGenre> genres) {
        tmdbUrl.addWithGenres(constructTvGenreIds(genres));
        return this;
    }

    public TmdbDiscoverTvRequest withoutGenres(List<TvGenre> genres) {
        tmdbUrl.addWithoutGenres(constructTvGenreIds(genres));
        return this;
    }

    private String constructTvGenreIds(List<TvGenre> movieGenres) {
        return movieGenres.stream()
                .map(TvGenre::getId)
                .collect(Collectors.joining(","));
    }

    @Override
    public DiscoverTv fetch() {
        URL url = tmdbUrl.build();
        return tmdbHttpClient.fetch(url, DiscoverTv.class);
    }

    @Override
    protected TmdbDiscoverTvRequest thisInstance() {
        return this;
    }

}
