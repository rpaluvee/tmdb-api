# Java library for the TMDb API

A lightweight Java library for The Movie Database (TMDb) API. The TMDb API is a 
resource for developers to integrate movie, TV show and cast data along with 
posters or movie fan art. [themoviedb.org](https://www.themoviedb.org/) is a 
free and community edited database.

## Scope

The purpose of this library is to provide its user with the ability to easily 
search for movies and TV shows and receive details about them.   
This library supports only the `/discover`, `/movie`, `/tv` methods of the Movie 
Database API. To view all the methods available, you should head over to 
[TMDb API overview](https://www.themoviedb.org/documentation/api)

## Features

#### Discover features

* Search for movies `GET /discover/movie` and TV shows `GET /discover/tv` based 
on filter. Movies are queryable by fields like average rating, certifications, 
release dates and genres.
* Get movie details:  
  * Average rating
  * Popularity
  * Title
  * Release date
  * Original language
  * Original title
  * Overview
  * Adult
  * Genre 

#### Custom library features

* Fetch a random movie/show from filtered/unfiltered `/discover` request.

### To do:

#### Movie Features

* Get additional details `GET /movie/{movie_id}`
  * Primary info
  * Alternative titles
  * Cast
  * Crew
  * Images (posters, backdrops)
  * Plot keywords
  * Release information
  * Trailers
  * Translations
  * Similiar movies
  * Reviews
  * Belongs to lists
  * Changes

#### TV Features

* Get additional details `GET /tv/{tv_id}`
  * Primary info
  * Cast
  * Changes
  * Crew
  * Images (posters, backdrops)
  * External IDs
  * Translations
  
#### Custom library features

* Filter movies and TV shows by result page range

## Technologies

Project is created with:  

#### Language
  * Java SE 8
#### Libraries
  * Lombok 1.18.10
  * Gson 2.8.6

## Setup
Add the library as a dependency to your project with Maven  
```
<dependency>
    <groupId>com.cinemadice</groupId>
    <artifactId>tmdb-api</artifactId>
    <version>1.0</version>
</dependency>
```

TODO: Gradle

## Usage
TMDb API key is required to use this library. Steps to register for an API key 
are described in the *Getting started* section of the 
[TMDb API documentation](https://developers.themoviedb.org/3/getting-started/introduction).

To use the library you have to instantiate the TMDb API Client class
`com.cinemadice.tmdbapi.TmdbClient` with the API key:  

`TmdbClient tmdbClient = new TmdbClient("<API_KEY>");`  

With this client you can specify whether to discover movies or TV shows. 
For example if you want to fetch all movies released in 2008:  
```
List<Movie> movies = tmdbClient.movies().filter()
        .withPrimaryReleaseYear(2008)
        .fetch();
```

## License
TODO: Add MIT license
