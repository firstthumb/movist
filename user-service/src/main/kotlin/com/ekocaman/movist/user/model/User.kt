package com.ekocaman.movist.user.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
        val username: String,
        val password: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1
)