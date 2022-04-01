package br.com.raphasalomao.microkotlin.bookservice.proxy

import br.com.raphasalomao.microkotlin.bookservice.model.Exchange
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.math.BigDecimal

@FeignClient(name = "exchange-service")
interface ExchangeProxy {

    @GetMapping("/exchange-service/api/v1/{amount}/{from}/{to}")
    fun getExchange(
        @PathVariable amount: BigDecimal,
        @PathVariable from: String,
        @PathVariable to: String
    ): Exchange

}