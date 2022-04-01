package br.com.raphasalomao.microkotlin.exchangeservice.model

import java.math.BigDecimal
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Exchange(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID,
    val fromCurrency: String,
    val toCurrency: String,
    val conversionFactor: BigDecimal,
    @Transient
    var convertedValue: BigDecimal,
    @Transient
    var env: String,
)