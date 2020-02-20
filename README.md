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

To use the library you have to instantiate the TMDb API Client class
`com.cinemadice.tmdbapi.client.TmdbClient` with the API Access Token:  

`TmdbClient tmdbClient = new TmdbClient("<ACCESS_TOKEN>");`  

With this client you can specify whether to discover movies or TV shows. 
For example if you want to fetch all movies released in 2008:  
```
List<Movie> movies = tmdbClient.discover().movies()
        .withPrimaryReleaseYear(2008)
        .fetch();
```

## Setup
Add the library as a dependency to your project with Maven  
```
<dependency>
    <groupId>com.cinemadice</groupId>
    <artifactId>tmdb-api</artifactId>
    <version>0.1.0</version>
</dependency>
```

TODO: Gradle

## Scope

The purpose of this library is to provide its user with the ability to easily 
search for movies and TV shows and receive details about them.   
This library supports only the `/discover`, `/movie`, `/tv` methods of the Movie 
Database API. To view all the methods available, you should head over to 
[TMDb API overview](https://www.themoviedb.org/documentation/api)

## Features

#### Discover features

* Search for movies `GET /discover/movie` and TV shows `GET /discover/tv` based 
on data. Movies are queryable by fields like average rating, certifications, 
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

* Filter movies and TV shows result by page range

## Technologies

Project is created with:  

#### Language
  * Java SE 8
#### Libraries
  * Lombok 1.18.10
  * Gson 2.8.6

## License
This project is released under the MIT license, see [LICENSE](LICENSE) file.
