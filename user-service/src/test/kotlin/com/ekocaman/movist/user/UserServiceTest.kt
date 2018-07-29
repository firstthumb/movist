package com.ekocaman.movist.user

import com.ekocaman.movist.user.service.UserService
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.fail
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class UserServiceTest {
    @Autowired
    lateinit var userService: UserService

    @Before
    fun setup() {

    }

    @Test
    fun testCreateUser() {
        userService.create("username", "password")
                .subscribe({
                    assertNotNull(it)
                }, {
                    fail(it.message)
                })
    }

    @Test
    fun testLoginUser() {
        userService.create("username", "password")
                .subscribe({ user ->
                    assertNotNull(user)
                    userService.login(user.username, user.password)
                            .subscribe({ loggedUser ->
                                assertNotNull(loggedUser)
                            }, {
                                fail(it.message)
                            })
                }, {
                    fail(it.message)
                })
    }
}