package com.ekocaman.movist.movie.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Movie(
        val title: String,
        val actors: String,
        val plot: String,
        val poster: String,
        @Id
        val id: String
)