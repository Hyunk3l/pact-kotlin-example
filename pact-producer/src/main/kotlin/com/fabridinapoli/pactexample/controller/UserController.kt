package com.fabridinapoli.pactexample.controller

import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/v1/users")
class UserController {

    @GetMapping("")
    fun getUsers() : ResponseEntity<ResponseUsers> {

        val users = listOf(
                User("Fabri", "Di Napoli")
        )

        val responseHeaders = HttpHeaders()
        responseHeaders.set("Content-Type",
                "application/json")

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(ResponseUsers(users = users))

    }
}

data class User(val name: String, val surname: String)

data class ResponseUsers(val users: List<User>)