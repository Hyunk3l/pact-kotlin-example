package com.fabridinapoli.pactconsumer.infrastructure.http

import com.fabridinapoli.pactconsumer.domain.user.User
import com.fabridinapoli.pactconsumer.domain.user.UserAdapter
import org.springframework.boot.web.client.RestTemplateBuilder

class HttpUserAdapter(private val url: String): UserAdapter {

    override fun findUsers(): List<User> {
        val client = RestTemplateBuilder()
                .setConnectTimeout(2000)
                .setReadTimeout(2000)
                .build()

        val result =  client.getForObject(url, HttpResponse::class.java)

        if (result != null) {
            return result.users.map { User(it.name, it.surname) }.toList()
        }
        return emptyList()
    }
}

data class HttpUserResponse(val name: String, val surname: String)

data class HttpResponse(val users: List<HttpUserResponse>)
