package br.com.raphasalomao.microkotlin.exchangeservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
class ExchangeServiceApplication

fun main(args: Array<String>) {
	runApplication<ExchangeServiceApplication>(*args)
}
