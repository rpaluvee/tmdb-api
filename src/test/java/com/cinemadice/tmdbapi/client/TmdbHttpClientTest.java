package com.cinemadice.tmdbapi.client;

import com.cinemadice.tmdbapi.exception.FailedTmdbRequestException;
import com.cinemadice.tmdbapi.model.Genre;
import com.cinemadice.tmdbapi.model.ImagesConfiguration;
import com.cinemadice.tmdbapi.model.ProductionCompany;
import com.cinemadice.tmdbapi.model.TmdbApiConfiguration;
import com.cinemadice.tmdbapi.model.TmdbErrorResponse;
import com.cinemadice.tmdbapi.model.discover.DiscoverMovies;
import com.cinemadice.tmdbapi.model.discover.DiscoverTv;
import com.cinemadice.tmdbapi.model.movies.Dates;
import com.cinemadice.tmdbapi.model.movies.Movie;
import com.cinemadice.tmdbapi.model.movies.MovieDetails;
import com.cinemadice.tmdbapi.model.movies.ProductionCountry;
import com.cinemadice.tmdbapi.model.movies.SpokenLanguage;
import com.cinemadice.tmdbapi.model.movies.UpcomingMovies;
import com.cinemadice.tmdbapi.model.tv.CreatedBy;
import com.cinemadice.tmdbapi.model.tv.LastEpisodeToAir;
import com.cinemadice.tmdbapi.model.tv.Network;
import com.cinemadice.tmdbapi.model.tv.Season;
import com.cinemadice.tmdbapi.model.tv.TvAiringToday;
import com.cinemadice.tmdbapi.model.tv.TvDetails;
import com.cinemadice.tmdbapi.model.tv.TvSeries;
import com.cinemadice.tmdbapi.url.Endpoint;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class TmdbHttpClientTest {

    private static final String ACCESS_TOKEN = "<ACCESS_TOKEN>";

    private TmdbHttpClient tmdbHttpClient = new TmdbHttpClient(ACCESS_TOKEN);
    private static MockWebServer server;
    private static Headers headers;

    @BeforeAll
    static void setUp() throws IOException {
        headers = new Headers.Builder()
                .add("Authorization", "Bearer " + ACCESS_TOKEN)
                .add("Content-Type", "application/json;charset=utf-8")
                .build();

        server = new MockWebServer();
        server.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        server.shutdown();
    }

    @Nested
    class WhenResponseUnsuccessful {

        @Test
        public void shouldFetchErrorResponse() {
            // given
            TmdbErrorResponse expected = new TmdbErrorResponse();
            expected.setStatusCode(7);
            expected.setStatusMessage("Invalid API key: You must be granted a valid key.");
            expected.setSuccess(false);

            HttpUrl serverUrl = server.url("/some/endpoint");
            MockResponse mockResponse = new MockResponse()
                    .setHeaders(headers)
                    .setResponseCode(HttpURLConnection.HTTP_UNAUTHORIZED)
                    .setBody(TestResourceFileReader.readFileContents("unauthorized_response.json"));
            server.enqueue(mockResponse);

            try {
                // when
                tmdbHttpClient.fetch(serverUrl.url(), TmdbErrorResponse.class);
                fail();
            } catch (FailedTmdbRequestException e) {
                // then
                assertEquals(expected, e.getTmdbErrorResponse());
            }
        }

        @Test
        public void shouldThrowExceptionGivenBadJson() {
            // given
            HttpUrl serverUrl = server.url("/some/endpoint");
            MockResponse mockResponse = new MockResponse()
                    .setHeaders(headers)
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody("bad_json");
            server.enqueue(mockResponse);

            // then
            assertThrows(FailedTmdbRequestException.class,
                    () -> tmdbHttpClient.fetch(serverUrl.url(), TmdbErrorResponse.class));
        }

        @Test
        public void shouldThrowExceptionGivenUnauthorized() {
            // given
            HttpUrl serverUrl = server.url("/some/endpoint");
            MockResponse mockResponse = new MockResponse()
                    .setHeaders(headers)
                    .setResponseCode(HttpURLConnection.HTTP_UNAUTHORIZED)
                    .setBody(TestResourceFileReader.readFileContents("unauthorized_response.json"));
            server.enqueue(mockResponse);

            // then
            assertThrows(FailedTmdbRequestException.class,
                    () -> tmdbHttpClient.fetch(serverUrl.url(), TmdbErrorResponse.class));
        }
    }

    @Nested
    class WhenResponseSuccessful {

        @Test
        public void shouldFetchDiscoverMovies() {
            // given
            List<Integer> firstMovieGenreIds = new ArrayList<>();
            firstMovieGenreIds.add(28);
            firstMovieGenreIds.add(12);
            firstMovieGenreIds.add(18);
            firstMovieGenreIds.add(10751);

            Movie firstMovie = new Movie();
            firstMovie.setPosterPath(null);
            firstMovie.setAdult(false);
            firstMovie.setOverview("Amy is only...");
            firstMovie.setReleaseDate("1996-09-13");
            firstMovie.setGenreIds(firstMovieGenreIds);
            firstMovie.setId(11076);
            firstMovie.setOriginalTitle("Fly Away Home");
            firstMovie.setOriginalLanguage("en");
            firstMovie.setTitle("Fly Away Home");
            firstMovie.setBackdropPath(null);
            firstMovie.setPopularity(1.022039f);
            firstMovie.setVoteCount(13);
            firstMovie.setVideo(false);
            firstMovie.setVoteAverage(6.69);

            List<Integer> secondMovieGenreIds = new ArrayList<>();
            secondMovieGenreIds.add(18);
            secondMovieGenreIds.add(10749);

            Movie secondMovie = new Movie();
            secondMovie.setPosterPath(null);
            secondMovie.setAdult(false);
            secondMovie.setOverview("With their father away...");
            secondMovie.setReleaseDate("1994-12-21");
            secondMovie.setGenreIds(secondMovieGenreIds);
            secondMovie.setId(9587);
            secondMovie.setOriginalTitle("Little Women");
            secondMovie.setOriginalLanguage("en");
            secondMovie.setTitle("Little Women");
            secondMovie.setBackdropPath(null);
            secondMovie.setPopularity(1.051359f);
            secondMovie.setVoteCount(50);
            secondMovie.setVideo(false);
            secondMovie.setVoteAverage(6.65);

            List<Movie> movies = new ArrayList<>();
            movies.add(firstMovie);
            movies.add(secondMovie);

            DiscoverMovies expected = new DiscoverMovies();
            expected.setPage(1);
            expected.setTotalResults(61);
            expected.setTotalPages(4);
            expected.setResults(movies);

            HttpUrl serverUrl = server.url(Endpoint.DISCOVER_MOVIE.getUrl());
            MockResponse mockResponse = new MockResponse()
                    .setHeaders(headers)
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(TestResourceFileReader.readFileContents("discover_movies_response.json"));
            server.enqueue(mockResponse);

            // when
            DiscoverMovies actual = tmdbHttpClient.fetch(serverUrl.url(), DiscoverMovies.class);

            // then
            assertEquals(expected, actual);
        }

        @Test
        public void shouldFetchUpcomingMovie() {
            // given
            List<Integer> genreIds = new ArrayList<>();
            genreIds.add(18);

            Dates dates = new Dates();
            dates.setMaximum("2016-09-22");
            dates.setMinimum("2016-09-01");

            Movie movie = new Movie();
            movie.setPosterPath("/pEFRzXtLmxYNjGd0XqJDHPDFKB2.jpg");
            movie.setAdult(false);
            movie.setOverview("A lighthouse keeper...");
            movie.setReleaseDate("2016-09-02");
            movie.setGenreIds(genreIds);
            movie.setId(283552);
            movie.setOriginalTitle("The Light Between Oceans");
            movie.setOriginalLanguage("en");
            movie.setTitle("The Light Between Oceans");
            movie.setBackdropPath("/2Ah63TIvVmZM3hzUwR5hXFg2LEk.jpg");
            movie.setPopularity(4.546151f);
            movie.setVoteCount(11);
            movie.setVideo(false);
            movie.setVoteAverage(4.41);

            List<Movie> movies = new ArrayList<>();
            movies.add(movie);

            UpcomingMovies expected = new UpcomingMovies();
            expected.setPage(1);
            expected.setTotalResults(222);
            expected.setTotalPages(12);
            expected.setResults(movies);
            expected.setDates(dates);

            HttpUrl serverUrl = server.url(Endpoint.UPCOMING_MOVIE.getUrl());
            MockResponse mockResponse = new MockResponse()
                    .setHeaders(headers)
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(TestResourceFileReader.readFileContents("upcoming_movies_response.json"));
            server.enqueue(mockResponse);

            // when
            UpcomingMovies actual = tmdbHttpClient.fetch(serverUrl.url(), UpcomingMovies.class);

            // then
            assertEquals(expected, actual);
        }

        @Test
        public void shouldFetchMovieDetails() {
            // given
            Genre genre = new Genre();
            genre.setId(18);
            genre.setName("Drama");
            List<Genre> genres = new ArrayList<>();
            genres.add(genre);

            ProductionCompany productionCompany = new ProductionCompany();
            productionCompany.setId(508);
            productionCompany.setLogoPath("/7PzJdsLGlR7oW4J0J5Xcd0pHGRg.png");
            productionCompany.setName("Regency Enterprises");
            productionCompany.setOriginCountry("US");
            List<ProductionCompany> productionCompanies = new ArrayList<>();
            productionCompanies.add(productionCompany);

            ProductionCountry productionCountry = new ProductionCountry();
            productionCountry.setIso("US");
            productionCountry.setName("United States of America");
            List<ProductionCountry> productionCountries = new ArrayList<>();
            productionCountries.add(productionCountry);

            SpokenLanguage spokenLanguage = new SpokenLanguage();
            spokenLanguage.setIso("en");
            spokenLanguage.setName("English");
            List<SpokenLanguage> spokenLanguages = new ArrayList<>();
            spokenLanguages.add(spokenLanguage);

            MovieDetails expected = new MovieDetails();
            expected.setAdult(false);
            expected.setBackdropPath("/fCayJrkfRaCRCTh8GqN30f8oyQF.jpg");
            expected.setBelongsToCollection(null);
            expected.setBudget(63000000);
            expected.setGenres(genres);
            expected.setHomepage("");
            expected.setId(550);
            expected.setImdbId("tt0137523");
            expected.setOriginalLanguage("en");
            expected.setOriginalTitle("Fight Club");
            expected.setOverview("A ticking-time-bomb...");
            expected.setPopularity(0.5f);
            expected.setPosterPath(null);
            expected.setProductionCompanies(productionCompanies);
            expected.setProductionCountries(productionCountries);
            expected.setReleaseDate("1999-10-12");
            expected.setRevenue(100853753);
            expected.setRuntime(139);
            expected.setSpokenLanguages(spokenLanguages);
            expected.setStatus("Released");
            expected.setTagline("How much can...");
            expected.setTitle("Fight Club");
            expected.setVideo(false);
            expected.setVoteAverage(7.8);
            expected.setVoteCount(3439);

            HttpUrl serverUrl = server.url(Endpoint.MOVIE_DETAILS.getUrl());
            MockResponse mockResponse = new MockResponse()
                    .setHeaders(headers)
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(TestResourceFileReader.readFileContents("movie_details_response.json"));
            server.enqueue(mockResponse);

            // when
            MovieDetails actual = tmdbHttpClient.fetch(serverUrl.url(), MovieDetails.class);

            // then
            assertEquals(expected, actual);
        }

        @Test
        public void shouldFetchDiscoverTv() {
            // given
            List<Integer> genreIds = new ArrayList<>();
            genreIds.add(28);

            List<String> originCountry = new ArrayList<>();
            originCountry.add("US");

            TvSeries tvSeries = new TvSeries();
            tvSeries.setPosterPath("/dDfjzRicTeVaiysRTwx56aM8bC3.jpg");
            tvSeries.setPopularity(5.4f);
            tvSeries.setId(61889);
            tvSeries.setBackdropPath(null);
            tvSeries.setVoteAverage(7.74);
            tvSeries.setOverview("Lawyer-by-day Matt Murdock...");
            tvSeries.setFirstAirDate("2015-04-10");
            tvSeries.setOriginCountry(originCountry);
            tvSeries.setGenreIds(genreIds);
            tvSeries.setOriginalLanguage("en");
            tvSeries.setVoteCount(19);
            tvSeries.setName("Marvel's Daredevil");
            tvSeries.setOriginalName("Marvel's Daredevil");

            List<TvSeries> tvSeriesList = new ArrayList<>();
            tvSeriesList.add(tvSeries);

            DiscoverTv expected = new DiscoverTv();
            expected.setPage(1);
            expected.setTotalResults(61470);
            expected.setTotalPages(3074);
            expected.setResults(tvSeriesList);

            HttpUrl serverUrl = server.url(Endpoint.DISCOVER_TV.getUrl());
            MockResponse mockResponse = new MockResponse()
                    .setHeaders(headers)
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(TestResourceFileReader.readFileContents("discover_tv_response.json"));
            server.enqueue(mockResponse);

            // when
            DiscoverTv actual = tmdbHttpClient.fetch(serverUrl.url(), DiscoverTv.class);

            // then
            assertEquals(expected, actual);
        }

        @Test
        public void shouldFetchTvAiringToday() {
            // given
            List<Integer> genreIds = new ArrayList<>();
            genreIds.add(18);

            List<String> originCountry = new ArrayList<>();
            originCountry.add("GB");

            TvSeries tvSeries = new TvSeries();
            tvSeries.setPosterPath("/zra8NrzxaEeunRWJmUm3HZOL4sd.jpg");
            tvSeries.setPopularity(11.520271f);
            tvSeries.setId(67419);
            tvSeries.setBackdropPath("/b0BckgEovxYLBbIk5xXyWYQpmlT.jpg");
            tvSeries.setVoteAverage(1.39);
            tvSeries.setOverview("The early life of...");
            tvSeries.setFirstAirDate("2016-08-28");
            tvSeries.setOriginCountry(originCountry);
            tvSeries.setGenreIds(genreIds);
            tvSeries.setOriginalLanguage("en");
            tvSeries.setVoteCount(9);
            tvSeries.setName("Victoria");
            tvSeries.setOriginalName("Victoria");

            List<TvSeries> tvSeriesList = new ArrayList<>();
            tvSeriesList.add(tvSeries);

            TvAiringToday expected = new TvAiringToday();
            expected.setPage(1);
            expected.setTotalResults(43);
            expected.setTotalPages(3);
            expected.setResults(tvSeriesList);

            HttpUrl serverUrl = server.url(Endpoint.TV_AIRING_TODAY.getUrl());
            MockResponse mockResponse = new MockResponse()
                    .setHeaders(headers)
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(TestResourceFileReader.readFileContents("tv_airing_today_response.json"));
            server.enqueue(mockResponse);

            // when
            TvAiringToday actual = tmdbHttpClient.fetch(serverUrl.url(), TvAiringToday.class);

            // then
            assertEquals(expected, actual);
        }

        @Test
        public void shouldFetchTvDetails() {
            // given
            CreatedBy createdBy = new CreatedBy();
            createdBy.setId(228068);
            createdBy.setCreditId("552e611e9251413fea000901");
            createdBy.setName("D. B. Weiss");
            createdBy.setGender(2);
            createdBy.setProfilePath("/caUAtilEe06OwOjoQY3B7BgpARi.jpg");
            List<CreatedBy> createdByList = new ArrayList<>();
            createdByList.add(createdBy);

            List<Integer> episodeRunTime = new ArrayList<>();
            episodeRunTime.add(60);

            Genre genre = new Genre();
            genre.setId(10759);
            genre.setName("Action & Adventure");
            List<Genre> genres = new ArrayList<>();
            genres.add(genre);

            List<String> languages = new ArrayList<>();
            languages.add("es");
            languages.add("en");
            languages.add("de");

            LastEpisodeToAir lastEpisodeToAir = new LastEpisodeToAir();
            lastEpisodeToAir.setAirDate("2017-08-27");
            lastEpisodeToAir.setEpisodeNumber(7);
            lastEpisodeToAir.setId(1340528);
            lastEpisodeToAir.setName("The Dragon and the Wolf");
            lastEpisodeToAir.setOverview("A meeting is held...");
            lastEpisodeToAir.setProductionCode("707");
            lastEpisodeToAir.setSeasonNumber(7);
            lastEpisodeToAir.setShowId(1399);
            lastEpisodeToAir.setStillPath("/jLe9VcbGRDUJeuM8IwB7VX4GDRg.jpg");
            lastEpisodeToAir.setVoteAverage(9.145f);
            lastEpisodeToAir.setVoteCount(31);

            Network network = new Network();
            network.setName("HBO");
            network.setId(49);
            network.setLogoPath("/tuomPhY2UtuPTqqFnKMVHvSb724.png");
            network.setOriginCountry("US");
            List<Network> networks = new ArrayList<>();
            networks.add(network);

            List<String> originCountry = new ArrayList<>();
            originCountry.add("US");

            ProductionCompany productionCompany = new ProductionCompany();
            productionCompany.setId(76043);
            productionCompany.setLogoPath("/9RO2vbQ67otPrBLXCaC8UMp3Qat.png");
            productionCompany.setName("Revolution Sun Studios");
            productionCompany.setOriginCountry("US");
            List<ProductionCompany> productionCompanies = new ArrayList<>();
            productionCompanies.add(productionCompany);

            Season season = new Season();
            season.setAirDate("2010-12-05");
            season.setEpisodeCount(14);
            season.setId(3627);
            season.setName("Specials");
            season.setOverview("");
            season.setPosterPath("/kMTcwNRfFKCZ0O2OaBZS0nZ2AIe.jpg");
            season.setSeasonNumber(0);
            List<Season> seasons = new ArrayList<>();
            seasons.add(season);

            TvDetails expected = new TvDetails();
            expected.setBackdropPath("/gX8SYlnL9ZznfZwEH4KJUePBFUM.jpg");
            expected.setCreatedBy(createdByList);
            expected.setEpisodeRunTime(episodeRunTime);
            expected.setFirstAirDate("2011-04-17");
            expected.setGenres(genres);
            expected.setHomepage("http://www.hbo.com/game-of-thrones");
            expected.setId(1399);
            expected.setInProduction(true);
            expected.setLanguages(languages);
            expected.setLastAirDate("2017-08-27");
            expected.setLastEpisodeToAir(lastEpisodeToAir);
            expected.setName("Game of Thrones");
            expected.setNextEpisodeToAir(null);
            expected.setNetworks(networks);
            expected.setNumberOfEpisodes(67);
            expected.setNumberOfSeasons(7);
            expected.setOriginCountry(originCountry);
            expected.setOriginalLanguage("en");
            expected.setOriginalName("Game of Thrones");
            expected.setOverview("Seven noble families...");
            expected.setPopularity(53.516f);
            expected.setPosterPath("/gwPSoYUHAKmdyVywgLpKKA4BjRr.jpg");
            expected.setProductionCompanies(productionCompanies);
            expected.setSeasons(seasons);
            expected.setStatus("Returning Series");
            expected.setType("Scripted");
            expected.setVoteAverage(8.2);
            expected.setVoteCount(4682);

            HttpUrl serverUrl = server.url(Endpoint.TV_DETAILS.getUrl());
            MockResponse mockResponse = new MockResponse()
                    .setHeaders(headers)
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(TestResourceFileReader.readFileContents("tv_details_response.json"));
            server.enqueue(mockResponse);

            // when
            TvDetails actual = tmdbHttpClient.fetch(serverUrl.url(), TvDetails.class);

            // then
            assertEquals(expected, actual);
        }

        @Test
        public void shouldFetchConfiguration() {
            // given
            List<String> backdropSizes = new ArrayList<>();
            backdropSizes.add("w300");
            backdropSizes.add("original");
            List<String> logoSizes = new ArrayList<>();
            logoSizes.add("w45");
            logoSizes.add("original");
            List<String> posterSizes = new ArrayList<>();
            posterSizes.add("w500");
            posterSizes.add("w780");
            List<String> profileSizes = new ArrayList<>();
            profileSizes.add("w45");
            profileSizes.add("original");
            List<String> stillSizes = new ArrayList<>();
            stillSizes.add("w300");
            stillSizes.add("original");
            List<String> changeKeys = new ArrayList<>();
            changeKeys.add("biography");
            changeKeys.add("videos");
            ImagesConfiguration imagesConfiguration = new ImagesConfiguration();
            imagesConfiguration.setBaseUrl("http://image.tmdb.org/t/p/");
            imagesConfiguration.setSecureBaseUrl("https://image.tmdb.org/t/p/");
            imagesConfiguration.setBackdropSizes(backdropSizes);
            imagesConfiguration.setLogoSizes(logoSizes);
            imagesConfiguration.setPosterSizes(posterSizes);
            imagesConfiguration.setProfileSizes(profileSizes);
            imagesConfiguration.setStillSizes(stillSizes);

            TmdbApiConfiguration expected = new TmdbApiConfiguration();
            expected.setImagesConfiguration(imagesConfiguration);
            expected.setChangeKeys(changeKeys);

            HttpUrl serverUrl = server.url(Endpoint.CONFIGURATION.getUrl());
            MockResponse mockResponse = new MockResponse()
                    .setHeaders(headers)
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(TestResourceFileReader.readFileContents("configuration_response.json"));
            server.enqueue(mockResponse);

            // when
            TmdbApiConfiguration actual = tmdbHttpClient.fetch(serverUrl.url(), TmdbApiConfiguration.class);

            // then
            assertEquals(expected, actual);
        }
    }

}
