package com.ekocaman.movist.movie.web.response

data class MovieSearchItemResponse(
        val title: String,
        val actors: String,
        val plot: String,
        val poster: String,
        val id: String
)

data class MovieSearchResponse(
        val results: List<MovieSearchItemResponse>
)