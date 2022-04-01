package br.com.raphasalomao.microkotlin.exchangeservice.repository

import br.com.raphasalomao.microkotlin.exchangeservice.model.Exchange
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ExchangeRepository: JpaRepository<Exchange, UUID> {

    fun findByFromCurrencyAndToCurrency(from: String, to: String): Optional<Exchange>

}