package com.cinemadice.tmdbapi.url;

class TmdbUrl extends AbstractTmdbUrl {

    TmdbUrl (Endpoint endpoint) {
        super.endpoint = endpoint;
    }

    public void addLanguage(String language) {
        tmdbParameters.put(TmdbParameter.LANGUAGE, String.valueOf(language));
    }

}
