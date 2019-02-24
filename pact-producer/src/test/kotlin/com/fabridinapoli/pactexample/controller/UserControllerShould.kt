package com.fabridinapoli.pactexample.controller

import au.com.dius.pact.provider.junit.Provider
import au.com.dius.pact.provider.junit.RestPactRunner
import au.com.dius.pact.provider.junit.loader.PactFolder
import au.com.dius.pact.provider.junit.target.TestTarget
import au.com.dius.pact.provider.spring.target.MockMvcTarget
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

@RunWith(RestPactRunner::class)
@Provider("test_provider")
@PactFolder("pacts")
class UserControllerShould {

    @InjectMocks
    lateinit var userController: UserController

    @JvmField
    @TestTarget
    val target = MockMvcTarget()

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        target.setControllers(userController)
    }

    @Test
    fun `get a list of valid users`() {

    }
}