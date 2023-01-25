package dev.bettercode

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MetricsDemoApplication

fun main(args: Array<String>) {
	runApplication<MetricsDemoApplication>(*args)
}
