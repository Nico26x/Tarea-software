package co.edu.uniquindio.application.controller;

import co.edu.uniquindio.application.model.Book;
import co.edu.uniquindio.application.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Historia de Usuario 2: Buscar libros por cualquier combinación de autor, título e ISBN.
     *
     * Ejemplos:
     * GET /libros/buscar?autor=garcia
     * GET /libros/buscar?titulo=clean
     * GET /libros/buscar?isbn=9780132350884
     * GET /libros/buscar?autor=garcia&titulo=cien
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<Book>> buscar(
            @RequestParam(required = false) String autor,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String isbn
    ) {
        List<Book> resultados = bookService.buscarLibros(autor, titulo, isbn);
        return ResponseEntity.ok(resultados);
    }
}