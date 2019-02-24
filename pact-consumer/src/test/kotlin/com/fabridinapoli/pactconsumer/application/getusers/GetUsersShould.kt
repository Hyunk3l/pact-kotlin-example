package com.fabridinapoli.pactconsumer.application.getusers

import com.fabridinapoli.pactconsumer.domain.user.User
import com.fabridinapoli.pactconsumer.domain.user.UserAdapter
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class GetUsersShould {

    @Test
    fun `get a list of valid users`() {
        val adapter = Mockito.mock(UserAdapter::class.java)
        Mockito.`when`(adapter.findUsers()).thenReturn(USERS_LIST)
        val expectedResponse = GetUsersResponse(RESPONSE_USERS_LIST)

        val response = GetUsers(adapter).execute()

        assertThat(response).isEqualTo(expectedResponse)
        verify(adapter, times(1)).findUsers()
    }

    companion object {
        const val NAME = "Fabri"
        private const val SURNAME = "Di Napoli"

        val USERS_LIST = listOf(
                User(NAME, SURNAME)
        )

        val RESPONSE_USERS_LIST = listOf(ResponseUser("$NAME $SURNAME"))
    }
}