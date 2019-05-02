package tk.tarajki.reactive.controllers

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import tk.tarajki.reactive.models.Author
import tk.tarajki.reactive.models.Book
import tk.tarajki.reactive.services.BookService
import javax.validation.Valid

@RestController
@RequestMapping("/books")
class BookController(
        private val bookService: BookService
) {

    @GetMapping
    fun getAllBooks(): Flux<Book> {
        return bookService.findAllBooks()
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: String): Mono<Book> {
        return bookService.findBookById(id)
    }

    @DeleteMapping("/{id}")
    fun deleteBookById(@PathVariable id: String): Mono<Void> {
        return bookService.deleteBookById(id)
    }

    @PostMapping
    fun createBook(@RequestBody @Valid bookDto: Book): Mono<Book> {
        return bookService.createBook(bookDto)
    }
}