package com.ekocaman.movist.review.service

import org.springframework.stereotype.Service

interface ReviewService {
    fun review(movieId: String, rate: Int)
}

@Service("reviewService")
class ReviewServiceImpl : ReviewService {

    constructor()

    override fun review(movieId: String, rate: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}