package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.model.Discover;
import com.cinemadice.tmdbapi.model.Movie;

import java.util.ArrayList;

public class TmdbMoviesClient extends AbstractTmdbClient {

    private static final int TOTAL_PAGES = 500;
    private static final int FIRST_PAGE_NR = 1;

    TmdbMoviesClient(String apiKey) {
        super(apiKey);
    }

    public Movie fetchRandom() {
        TmdbUrl tmdbUrl = new TmdbUrl(Endpoint.DISCOVER_MOVIE)
                .addParameter(TmdbParameter.PAGE, Integer.toString(Utils.generateRandomNr(FIRST_PAGE_NR, TOTAL_PAGES)));

        Discover discover = deserializeJson(readUrl(tmdbUrl), Discover.class);

        int randomIndex = Utils.generateRandomNr(0, discover.getResults().size() - 1);
        return discover.getResults().get(randomIndex);
    }

    // TODO: currently fetches all movies in page 1 of response
    public ArrayList<Movie> fetchAll() {
        TmdbUrl tmdbUrl = new TmdbUrl(Endpoint.DISCOVER_MOVIE);
        Discover discover = deserializeJson(readUrl(tmdbUrl), Discover.class);
        return discover.getResults();
    }

    /*
    public Map<String, Object> fetchAll() {
        TmdbUrl tmdbUrl = new TmdbUrl(Endpoint.DISCOVER_MOVIE);

        Map discoverDto = deserializeJson(tmdbUrl, Map.class);
        ArrayList<Map<String, Object>> results = (ArrayList<Map<String, Object>>) discoverDto.get("results");
        System.out.println("results size: " + results.size());

        for (int pageNr = 1; pageNr <= TOTAL_PAGES; pageNr++) {

        }

        return discoverDto;
    }
    */

}
