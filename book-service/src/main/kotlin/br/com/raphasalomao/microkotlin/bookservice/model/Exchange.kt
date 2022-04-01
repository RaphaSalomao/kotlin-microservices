package br.com.raphasalomao.microkotlin.bookservice.model

import java.math.BigDecimal
import java.util.*

data class Exchange(
    val id: UUID,
    val fromCurrency: String,
    val toCurrency: String,
    val conversionFactor: BigDecimal,
    var convertedValue: BigDecimal,
    var env: String,
)