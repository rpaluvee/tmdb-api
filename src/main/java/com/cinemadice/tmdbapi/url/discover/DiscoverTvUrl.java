package com.cinemadice.tmdbapi.url.discover;

import com.cinemadice.tmdbapi.url.Endpoint;
import com.cinemadice.tmdbapi.url.TmdbParameter;

public class DiscoverTvUrl extends AbstractDiscoverUrl {

    public DiscoverTvUrl() {
        super(Endpoint.DISCOVER_TV);
    }

    public void addAirDateLessThanOrEqual(String airDate) {
        tmdbParameters.put(TmdbParameter.AIR_DATE_LTE, airDate);
    }

    public void addAirDateGreaterThanOrEqual(String airDate) {
        tmdbParameters.put(TmdbParameter.AIR_DATE_GTE, airDate);
    }

    public void addFirstAirDateLessThanOrEqual(String firstAirDate) {
        tmdbParameters.put(TmdbParameter.FIRST_AIR_DATE_LTE, firstAirDate);
    }

    public void addFirstAirDateGreaterThanOrEqual(String firstAirDate) {
        tmdbParameters.put(TmdbParameter.FIRST_AIR_DATE_GTE, firstAirDate);
    }

    public void addFirstAirDateYear(int firstAirDateYear) {
        tmdbParameters.put(TmdbParameter.FIRST_AIR_DATE_YEAR, String.valueOf(firstAirDateYear));
    }

    public void addTimezone(String timezone) {
        tmdbParameters.put(TmdbParameter.TIMEZONE, timezone);
    }

    public void addWithNetworks(String networks) {
        tmdbParameters.put(TmdbParameter.WITH_NETWORKS, networks);
    }

    public void addIncludeNullFirstAirDates(boolean hasAirDate) {
        tmdbParameters.put(TmdbParameter.INCLUDE_NULL_FIRST_AIR_DATES, String.valueOf(hasAirDate));
    }

    public void addScreenedTheatrically(boolean hasScreenedTheatrically) {
        tmdbParameters.put(TmdbParameter.SCREENED_THEATRICALLY, String.valueOf(hasScreenedTheatrically));
    }

}
