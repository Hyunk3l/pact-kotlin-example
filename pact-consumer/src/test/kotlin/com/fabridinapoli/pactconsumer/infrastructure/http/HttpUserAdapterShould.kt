package com.fabridinapoli.pactconsumer.infrastructure.http

import au.com.dius.pact.consumer.Pact
import au.com.dius.pact.consumer.PactProviderRuleMk2
import au.com.dius.pact.consumer.PactVerification
import au.com.dius.pact.consumer.dsl.PactDslWithProvider
import au.com.dius.pact.model.RequestResponsePact
import com.fabridinapoli.pactconsumer.domain.user.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import java.io.IOException


class HttpUserAdapterShould {
    @get:Rule
    val mockProvider = PactProviderRuleMk2("test_provider", "localhost", 8081, this)

    @Pact(consumer = "test_consumer", provider="test_provider")
    fun createPact(builder: PactDslWithProvider) : RequestResponsePact {
        val headers = mutableMapOf<String, String>()
        headers["Content-Type"] = "application/json"

        val body = """
            {"users":[{"name":"Fabri","surname":"Di Napoli"}]}
        """

       return builder
                .given("Test getUsers")
                .uponReceiving("GET REQUEST")
                .path("/v1/users")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(body)
                .toPact()
    }

    @Test
    @PactVerification("test_provider")
    @Throws(IOException::class)
    fun runTest() {
        val expectedUsers = listOf(User("Fabri", "Di Napoli"))

        val users = HttpUserAdapter(mockProvider.url + "/v1/users").findUsers()

        assertThat(users).isEqualTo(expectedUsers)
    }
}