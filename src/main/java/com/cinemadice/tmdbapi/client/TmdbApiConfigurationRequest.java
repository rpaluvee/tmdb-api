package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.model.TmdbApiConfiguration;
import com.cinemadice.tmdbapi.url.ConfigurationUrl;

import java.net.URL;

public class TmdbApiConfigurationRequest extends AbstractTmdbRequest<TmdbApiConfigurationRequest, ConfigurationUrl> {

    TmdbApiConfigurationRequest(ConfigurationUrl configurationUrl, TmdbHttpClient tmdbHttpClient) {
        super(configurationUrl, tmdbHttpClient);
    }

    @Override
    public TmdbApiConfiguration fetch() {
        URL url = tmdbUrl.build();
        return tmdbHttpClient.fetch(url, TmdbApiConfiguration.class);
    }

    @Override
    protected TmdbApiConfigurationRequest thisInstance() {
        return this;
    }

}
