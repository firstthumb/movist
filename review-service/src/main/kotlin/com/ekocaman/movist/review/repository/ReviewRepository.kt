package com.ekocaman.movist.review.repository

import com.ekocaman.movist.review.model.Review
import org.springframework.data.repository.CrudRepository

interface ReviewRepository : CrudRepository<Review, Long> {

}