package com.cinemadice.tmdbapi.methods;

import com.cinemadice.tmdbapi.*;
import com.cinemadice.tmdbapi.model.Discover;
import com.cinemadice.tmdbapi.Endpoint;
import com.cinemadice.tmdbapi.model.Movie;

import java.util.ArrayList;

public class TmdbMovies extends AbstractTmdbApi {

    private static final int TOTAL_PAGES = 500;
    private static final int FIRST_PAGE_NR = 1;

    public TmdbMovies(String apiKey) {
        super(apiKey);
    }

    public Movie fetchRandomMovie() {
        TmdbUrl tmdbUrl = new TmdbUrl(Endpoint.DISCOVER_MOVIE)
                .addParameter(TmdbParameter.PAGE, Integer.toString(Utils.generateRandomNr(FIRST_PAGE_NR, TOTAL_PAGES)));
        Discover discover = deserializeJson(tmdbUrl, Discover.class);

        int randomIndex = Utils.generateRandomNr(0, discover.getResults().size() - 1);

        return discover.getResults().get(randomIndex);
    }

    // TODO: currently fetches all movies in page 1 of response
    public ArrayList<Movie> fetchAllMovies() {
        TmdbUrl tmdbUrl = new TmdbUrl(Endpoint.DISCOVER_MOVIE);
        Discover discover = deserializeJson(tmdbUrl, Discover.class);
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
