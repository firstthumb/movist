package com.ekocaman.movist.user.service.client

import feign.Headers
import feign.RequestLine

@Headers("Content-Type: application/json")
interface MovieClient {
    @RequestLine("GET /movies")
    fun getMovies(): List<Movie>

//    companion object Factory {
//        fun create(): MovieClient {
//            return Feign.builder()
//                    .encoder(JacksonEncoder())
//                    .decoder(JacksonDecoder())
//                    .target(t, "http://localhost:${randomServerPort}")
//        }
//    }
}