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

A simple example of discovering movies released in 2008 with english language:  
```
TmdbClient tmdbClient = new TmdbClient("<ACCESS_TOKEN>");
List<Movie> movies = tmdbClient.discover().movies()
        .withPrimaryReleaseYear(2008)
        .language("en")
        .fetch();
```

More example of use can be found at [src/test/java/com/cinemadice/tmdbapi/samples/TmdbClientSamples.java](https://github.com/rpaluvee/tmdb-api/tree/master/src/test/java/com/cinemadice/tmdbapi/samples/TmdbClientSamples.java).

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
search for movies and TV shows and receive details about them.   
This library supports only the `/discover`, `/movie`, `/tv` methods of the Movie 
Database API. To view all the methods available, you should head over to 
[TMDb API overview](https://www.themoviedb.org/documentation/api)

## Features

#### Discover features

* Search for movies and TV shows based on data. Movies and TV shows are queryable by fields like average rating, 
certifications, release dates, genres and many more parameters.  
`tmdbClient.discover().movies()`  
`tmdbClient.discover().tv()`

#### Movie Features

* Search for upcoming movies in theatres  
`tmdbClient.movies().upcomingInTheatres()`

* Get additional details  
`tmdbClient.movies().detailsOf(<MOVIE_ID>)`

#### TV Features

* Search for TV shows airing today  
`tmdbClient.tv().airingToday()`

* Get additional details  
`tmdbClient.tv().detailsOf(<TV_ID>)`

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

To run analysis, use `mvn compile spotbugs:check`

To view results, use `mvn spotbugs:gui`

## License
This project is released under the MIT license, see [LICENSE](LICENSE) file.
