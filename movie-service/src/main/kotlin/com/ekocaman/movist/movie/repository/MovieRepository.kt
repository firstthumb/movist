package com.ekocaman.movist.movie.repository

import com.ekocaman.movist.movie.model.Movie
import org.springframework.data.repository.CrudRepository

interface MovieRepository : CrudRepository<Movie, String> {
    fun findByTitle(title: String): Iterable<Movie>
}