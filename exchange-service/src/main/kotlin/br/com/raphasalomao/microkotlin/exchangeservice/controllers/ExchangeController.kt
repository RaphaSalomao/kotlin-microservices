package br.com.raphasalomao.microkotlin.exchangeservice.controllers

import br.com.raphasalomao.microkotlin.exchangeservice.model.Exchange
import br.com.raphasalomao.microkotlin.exchangeservice.repository.ExchangeRepository
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*

@RestController
@RequestMapping("/")
class ExchangeController(
    private val environment: Environment,
    private val repository: ExchangeRepository
    ) {

    @GetMapping("/{amount}/{from}/{to}")
    fun getExchange(
        @PathVariable amount: BigDecimal,
        @PathVariable from: String,
        @PathVariable to: String
    ): Exchange {
        return repository.findByFromCurrencyAndToCurrency(from, to).orElseThrow().apply {
            this.convertedValue = (this.conversionFactor * amount).setScale(2, RoundingMode.CEILING)
            this.env = environment.getProperty("local.server.port")!!
        }
    }

}