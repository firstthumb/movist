package com.ekocaman.movist.user.service

import com.ekocaman.movist.user.model.User
import com.ekocaman.movist.user.repository.UserRepository
import io.reactivex.Observable
import org.springframework.stereotype.Service

interface UserService {
    fun create(username: String, password: String): Observable<User>

    fun login(username: String, password: String): Observable<User?>
}

@Service("userService")
class UserServiceImpl constructor(var userRepository: UserRepository) : UserService {

    override fun create(username: String, password: String): Observable<User> {
        return Observable.create {
            userRepository.save(User(username, password)).let { user ->
                it.onNext(user)
            }
            it.onComplete()
        }
    }

    override fun login(username: String, password: String): Observable<User?> {
        return Observable.create {
            userRepository.findUserByUsername(username)?.let { user ->
                it.onNext(user)
            }
            it.onComplete()
        }
    }
}