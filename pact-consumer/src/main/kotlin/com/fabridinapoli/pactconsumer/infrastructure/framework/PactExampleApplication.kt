package com.fabridinapoli.pactconsumer.infrastructure.framework

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PactExampleApplication

fun main(args: Array<String>) {
	runApplication<PactExampleApplication>(*args)
}
