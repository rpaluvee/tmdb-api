# Java library for the TMDb API

A lightweight Java library for The Movie Database (TMDb) API. The TMDb API is a 
resource for developers to integrate movie, TV show and cast data along with 
posters or movie fan art. [themoviedb.org](https://www.themoviedb.org/) is a 
free and community edited database.

## Usage
TMDb [API Read Access Token](https://developers.themoviedb.org/4/getting-started/authorization) 
is required to use this library. This Access Token can be obtained by registering for 
a TMDb API key. Steps to do so are described in the *Getting started* section of the 
[TMDb API documentation](https://developers.themoviedb.org/3/getting-started/introduction).

To use the library you have to initialize the TMDb API Client class
`com.cinemadice.tmdbapi.client.TmdbClient` with the API Access Token:
```
TmdbClient tmdbClient = new TmdbClient("<ACCESS_TOKEN>");
```
A simple example of discovering movies that match the given filters:  
```
List<Movie> movies = tmdbClient.discover().movies()
        .withGenres(Arrays.asList(MovieGenre.ACTION, MovieGenre.COMEDY))
        .withRegion(Region.UNITED_STATES_OF_AMERICA)
        .language(Language.ENGLISH)
        .withPrimaryReleaseYear(2018)
        .fetch()
        .getResults();
```
Fetching details (including credits, images and videos) about a specific movie:  
```
MovieDetails movieDetails = tmdbClient.movies().detailsOf(<MOVIE_ID>)
        .withAppendedResponse(Arrays.asList(
                AppendableMovieResponse.CREDITS,
                AppendableMovieResponse.IMAGES,
                AppendableMovieResponse.VIDEOS))
        .fetch();
```

More examples of use can be found at [src/test/java/com/cinemadice/tmdbapi/samples/TmdbClientSamples.java](https://github.com/rpaluvee/tmdb-api/tree/master/src/test/java/com/cinemadice/tmdbapi/samples/TmdbClientSamples.java).

## Installation
Include the library as a dependency to your project with Maven  
```
<dependency>
    <groupId>com.cinemadice</groupId>
    <artifactId>tmdb-api</artifactId>
    <version>0.1.0</version>
</dependency>
```

## Scope

The purpose of this library is to provide its user with the ability to easily 
use the features provided by the TMDb API. All of the supported features are 
described under the Features section.
To view all the features available in the TMDb API, you should head over to the
[TMDb API overview](https://www.themoviedb.org/documentation/api)

## Features

#### Discover features

* Search for movies based on various parameters such as average rating, 
cast, region, release year, genres and many more.  
`tmdbClient.discover().movies()...`  

* Search for TV shows based on various parameters such as air date, 
timezone, keywords, language, genres and many more.  
`tmdbClient.discover().tv()...`

#### Movie Features

* Search for upcoming movies in theatres  
`tmdbClient.movies().upcomingInTheatres()...`

* Get additional details  
`tmdbClient.movies().detailsOf(<MOVIE_ID>)...`

#### TV Features

* Search for TV shows airing today  
`tmdbClient.tv().airingToday()...`

* Get additional details  
`tmdbClient.tv().detailsOf(<TV_ID>)...`

#### People Features

* Get details about people (actors, directors, writers, etc.)  
`tmdbClient.people().detailsOf(<PERSON_ID>)...`

## Build

#### Prerequisites
  * Java JDK version 8

To build Java Archive use `$ ./mvnw clean package`

To run unit tests use `$ ./mvnw clean test`

## Technologies

Project is created with:  

#### Language
  * Java SE 8

#### Libraries
  * Lombok 1.18.10
  * Gson 2.8.6
  * OkHttp 4.3.1

## Static code analysis

### Checkstyle (http://checkstyle.sourceforge.net/)
Checkstyle is used to maintain a consistent code style.
Checkstyle is configured to run automatically in Maven validate phase.

### SpotBugs (https://spotbugs.github.io/)
SpotBugs analyzes bytecode to find common bugs and code problems.  

To run analysis, use `$ ./mvnw compile spotbugs:check`

To view results, use `$ ./mvnw spotbugs:gui`

## License
This project is released under the MIT license, see [LICENSE](LICENSE) file.
