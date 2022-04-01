package br.com.raphasalomao.microkotlin.bookservice.repository

import br.com.raphasalomao.microkotlin.bookservice.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface BookRepository: JpaRepository<Book, UUID> {
}