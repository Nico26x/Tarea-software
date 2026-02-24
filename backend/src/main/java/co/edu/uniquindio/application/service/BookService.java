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

    /**
     * HU2: Permite buscar por autor, título e ISBN en cualquier combinación.
     */
    public List<Book> buscarLibros(String autor, String titulo, String isbn) {
        autor = normalizar(autor);
        titulo = normalizar(titulo);
        isbn = normalizar(isbn);

        // Si no envían filtros, devolvemos todos (útil para probar).
        // Si tu profesor pide "debe venir al menos 1 filtro", aquí se podría lanzar excepción.
        if (autor == null && titulo == null && isbn == null) {
            return bookRepository.findAll();
        }

        return bookRepository.buscarPorAutorTituloIsbn(autor, titulo, isbn);
    }

    private String normalizar(String valor) {
        if (valor == null) return null;
        String limpio = valor.trim();
        return limpio.isEmpty() ? null : limpio;
    }
}