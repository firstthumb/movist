package com.ekocaman.movist.user.web

import com.ekocaman.movist.user.service.UserService
import com.ekocaman.movist.user.web.request.UserCreateRequest
import com.ekocaman.movist.user.web.response.UserResponse
import io.reactivex.Observable
import mu.KLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController constructor(var userService: UserService) {
    companion object : KLogging()

    @PostMapping("/")
    fun createUser(@RequestBody request: UserCreateRequest): Observable<UserResponse> {
        logger.info { "Create user by username => ${request.username}" }

        return userService.create(request.username, request.password)
                .map {
                    UserResponse(username = it.username, id = it.id)
                }
    }
}