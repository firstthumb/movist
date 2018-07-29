package com.ekocaman.movist.user.web.request

data class UserCreateRequest(
        val username: String,
        val password: String
)