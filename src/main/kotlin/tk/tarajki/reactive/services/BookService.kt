package tk.tarajki.reactive.services

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import tk.tarajki.reactive.models.Book
import tk.tarajki.reactive.repositories.BookRepository

@Service
class BookService(
        private val bookRepository: BookRepository
) {

    fun findAllBooks(): Flux<Book> {
        return bookRepository.findAll()
    }

    fun createBook(book: Book): Mono<Book> {
        return bookRepository.save(book)
    }

    fun findBookById(id: String): Mono<Book> {
        return bookRepository.findById(id)
    }

    fun deleteBookById(id: String): Mono<Void> {
        return bookRepository.deleteById(id)
    }

}