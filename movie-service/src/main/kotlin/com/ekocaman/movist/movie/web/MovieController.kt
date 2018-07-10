package com.ekocaman.movist.movie.web

import com.ekocaman.movist.movie.web.response.MovieSearchResponse
import mu.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.*
import javax.ws.rs.Path

@Path("movies")
class MovieController {
    companion object : KLogging()

    @GetMapping("/search")
    fun searchMovieByTitle(@RequestParam("title") title: String): List<MovieSearchResponse> {
        logger.info { "Search by title => $title" }
        return Collections.emptyList()
    }
}