package org.virtualization

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VirtualizationApplication

fun main(args: Array<String>) {
	runApplication<VirtualizationApplication>(*args)
}
