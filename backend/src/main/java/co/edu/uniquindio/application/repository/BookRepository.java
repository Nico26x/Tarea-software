package co.edu.uniquindio.application.repository;

import co.edu.uniquindio.application.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * HISTORIA DE USUARIO 2: Buscar libros por cualquier combinación de autor, título e ISBN.
     * - autor y titulo: búsqueda parcial
     * - isbn: búsqueda exacta
     */
    @Query("""
        SELECT b 
        FROM Book b
        WHERE (:autor IS NULL OR LOWER(b.autor) LIKE LOWER(CONCAT('%', :autor, '%')))
            AND (:titulo IS NULL OR LOWER(b.titulo) LIKE LOWER(CONCAT('%', :titulo, '%')))
            AND (:isbn IS NULL OR b.isbn = :isbn)
    """)
    List<Book> buscarPorAutorTituloIsbn(
        @Param("autor") String autor, 
        @Param("titulo") String titulo, 
        @Param("isbn") String isbn
    );
    
}
