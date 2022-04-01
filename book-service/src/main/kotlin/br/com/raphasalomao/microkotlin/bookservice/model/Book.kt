package br.com.raphasalomao.microkotlin.bookservice.model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID,
    val author: String,
    val launchDate: LocalDateTime,
    var price: BigDecimal,
    val title: String,
    @Transient
    var currency: String,
    @Transient
    var env: String
)