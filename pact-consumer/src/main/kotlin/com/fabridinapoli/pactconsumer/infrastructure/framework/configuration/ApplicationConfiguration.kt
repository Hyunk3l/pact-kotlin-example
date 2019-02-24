package com.fabridinapoli.pactconsumer.infrastructure.framework.configuration

import com.fabridinapoli.pactconsumer.application.getusers.GetUsers
import com.fabridinapoli.pactconsumer.domain.user.UserAdapter
import com.fabridinapoli.pactconsumer.infrastructure.http.HttpUserAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration {

    @Bean
    fun userAdapter(): UserAdapter = HttpUserAdapter("localhost:8081/v1/users")

    @Bean
    fun getUsers(adapter: UserAdapter): GetUsers = GetUsers(adapter)
}