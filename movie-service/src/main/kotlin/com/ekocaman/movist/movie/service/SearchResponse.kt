package com.ekocaman.movist.movie.service

import com.fasterxml.jackson.annotation.JsonProperty

data class SearchResponse(
        @JsonProperty("Title") val title: String,
        @JsonProperty("Year") val year: String,
        @JsonProperty("imdbID") val imdbID: String,
        @JsonProperty("Type") val type: String,
        @JsonProperty("Poster") val poster: String)