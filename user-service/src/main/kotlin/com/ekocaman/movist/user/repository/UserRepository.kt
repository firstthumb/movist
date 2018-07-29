package com.ekocaman.movist.user.repository

import com.ekocaman.movist.user.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findUserByUsername(username: String): User?
}