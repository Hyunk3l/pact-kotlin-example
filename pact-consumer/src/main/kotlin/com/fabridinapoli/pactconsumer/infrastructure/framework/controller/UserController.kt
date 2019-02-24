package com.fabridinapoli.pactconsumer.infrastructure.framework.controller

import com.fabridinapoli.pactconsumer.application.getusers.GetUsers
import com.fabridinapoli.pactconsumer.application.getusers.GetUsersResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/v1/users")
class UserController(val getUsers: GetUsers) {

    @GetMapping("/")
    fun getUsers() : GetUsersResponse {

        return getUsers.execute()
    }
}
