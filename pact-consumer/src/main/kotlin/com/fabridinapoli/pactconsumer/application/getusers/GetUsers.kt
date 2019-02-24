package com.fabridinapoli.pactconsumer.application.getusers

import com.fabridinapoli.pactconsumer.domain.user.UserAdapter
import kotlin.streams.toList

class GetUsers(private val adapter: UserAdapter) {

    fun execute() : GetUsersResponse {

        val users = adapter.findUsers()

        val responseUsers = users.orEmpty().stream().map {
            ResponseUser("${it.name} ${it.surname}")
        }.toList()

        return GetUsersResponse(responseUsers)
    }
}

data class GetUsersResponse(val responseUsers: List<ResponseUser>)

data class ResponseUser(val completeName: String)
