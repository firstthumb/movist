package com.ekocaman.movist.movie

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@Configuration
class ReviewApplication

fun main(args: Array<String>) {
    SpringApplication.run(ReviewApplication::class.java, *args)
}
