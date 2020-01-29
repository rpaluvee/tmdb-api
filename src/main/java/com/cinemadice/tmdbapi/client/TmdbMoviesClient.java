package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.model.Discover;
import com.cinemadice.tmdbapi.model.Movie;

import java.net.URL;
import java.util.List;

public class TmdbMoviesClient extends AbstractTmdbClient {

    private static final int TOTAL_PAGES = 500;
    private static final int FIRST_PAGE_NR = 1;

    private final String apiKey;

    TmdbMoviesClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public Movie fetchRandom() {
        URL url = new TmdbUrl(apiKey).discoverMovies()
                .addPage(Utils.generateRandomNr(FIRST_PAGE_NR, TOTAL_PAGES))
                .buildUrl();

        Discover discover = deserializeJson(readUrl(url), Discover.class);

        int randomIndex = Utils.generateRandomNr(0, discover.getResults().size() - 1);
        return discover.getResults().get(randomIndex);
    }

    // TODO: currently fetches all movies in page 1 of response
    public List<Movie> fetchAll() {
        URL url = new TmdbUrl(apiKey).discoverMovies().buildUrl();
        Discover discover = deserializeJson(readUrl(url), Discover.class);
        return discover.getResults();
    }

}
