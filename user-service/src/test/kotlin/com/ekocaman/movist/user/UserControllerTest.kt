package com.ekocaman.movist.user

import com.ekocaman.movist.user.service.UserService
import com.ekocaman.movist.user.web.request.UserCreateRequest
import com.ekocaman.movist.user.web.response.UserResponse
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [(UserApplication::class)],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Before
    fun setup() {

    }

    @Test
    fun testCreateUser() {
        val request = UserCreateRequest("username", "password")
        val result = testRestTemplate.postForEntity("/users", request, UserResponse::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
    }
}