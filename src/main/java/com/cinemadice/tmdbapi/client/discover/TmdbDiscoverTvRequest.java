package com.cinemadice.tmdbapi.client.discover;

import com.cinemadice.tmdbapi.client.TmdbHttpClient;
import com.cinemadice.tmdbapi.model.discover.DiscoverTv;
import com.cinemadice.tmdbapi.model.tv.TvSeries;
import com.cinemadice.tmdbapi.url.discover.DiscoverTvUrl;
import java.net.URL;
import java.util.List;

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

    @Override
    public List<TvSeries> fetch() {
        URL url = tmdbUrl.build();
        DiscoverTv discoverTv = tmdbHttpClient.fetch(url, DiscoverTv.class);
        return discoverTv.getResults();
    }

    @Override
    protected TmdbDiscoverTvRequest thisInstance() {
        return this;
    }

}
