package tk.tarajki.reactive.repositories

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import tk.tarajki.reactive.models.Book

@Repository
interface BookRepository : ReactiveMongoRepository<Book, String>