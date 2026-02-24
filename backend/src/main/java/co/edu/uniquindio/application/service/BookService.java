package co.edu.uniquindio.application.service;

import co.edu.uniquindio.application.model.Book;
import co.edu.uniquindio.application.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Obtener todos
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Buscar por palabra o frase
    public List<Book> searchBooks(String query) {
        return bookRepository
                .findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(query, query);
    }
}