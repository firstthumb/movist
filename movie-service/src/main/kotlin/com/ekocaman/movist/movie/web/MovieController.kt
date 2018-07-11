package com.ekocaman.movist.movie.web

import com.ekocaman.movist.movie.service.MovieService
import com.ekocaman.movist.movie.web.response.MovieSearchItemResponse
import com.ekocaman.movist.movie.web.response.MovieSearchResponse
import io.reactivex.Observable
import mu.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movies")
class MovieController constructor(var movieService: MovieService) {
    companion object : KLogging()

    @GetMapping("/search")
    fun searchMovieByTitle(@RequestParam("title") title: String,
                           @RequestParam("year", required = false) year: String?,
                           @RequestParam("type", required = false) type: String?): Observable<MovieSearchResponse> {
        logger.info { "Search by title => $title year => $year type => $type" }

        return movieService.searchMovies(title, year, type)
                .map {
                    it.search
                }
                .map {
                    MovieSearchResponse(
                            it.map {
                                MovieSearchItemResponse(
                                        title = it.title,
                                        poster = "",
                                        plot = "",
                                        id = it.imdbID,
                                        actors = ""
                                )
                            }
                    )
                }
    }
}