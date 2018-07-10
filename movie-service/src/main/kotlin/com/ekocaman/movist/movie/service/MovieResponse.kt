package com.ekocaman.movist.movie.service

import com.fasterxml.jackson.annotation.JsonProperty

data class MovieResponse(
        @JsonProperty("imdbID") val imdbId: String,
        @JsonProperty("Title") val title: String,
        @JsonProperty("Actors") val actors: String,
        @JsonProperty("Plot") val plot: String,
        @JsonProperty("imdbRating") val imdbRating: String,
        @JsonProperty("Poster") val poster: String)