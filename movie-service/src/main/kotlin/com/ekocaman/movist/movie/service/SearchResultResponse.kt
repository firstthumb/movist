package com.ekocaman.movist.movie.service

import com.fasterxml.jackson.annotation.JsonProperty

data class SearchResultResponse(
        @JsonProperty("Search") val search: List<SearchResponse>,
        @JsonProperty("totalResults") val totalResults: String,
        @JsonProperty("Response") val response: String)