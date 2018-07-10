package com.ekocaman.movist.movie.web.response

data class MovieSearchResponse(
        val title: String,
        val actors: String,
        val plot: String,
        val poster: String,
        val id: String
)