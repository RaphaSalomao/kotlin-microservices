package br.com.raphasalomao.microkotlin.bookservice.controllers

import br.com.raphasalomao.microkotlin.bookservice.model.Book
import br.com.raphasalomao.microkotlin.bookservice.model.Exchange
import br.com.raphasalomao.microkotlin.bookservice.proxy.ExchangeProxy
import br.com.raphasalomao.microkotlin.bookservice.repository.BookRepository
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.math.BigDecimal
import java.util.*

@RestController
class BookController(
    private val repository: BookRepository,
    private val exchangeProxy: ExchangeProxy,
    private val environment: Environment
) {

    @GetMapping("/{id}/{currency}")
    fun getBook(@PathVariable id: UUID, @PathVariable currency: String): Book {
        val book = repository.findById(id)
            .orElseThrow()

        val exchangeResponse = exchangeProxy.getExchange(book.price, "USD", currency)
        return book
            .apply {
                this.price = exchangeResponse?.convertedValue
                this.currency = currency
                this.env = "${environment.getProperty("local.server.port")}:${exchangeResponse.env}"
            }
    }
}