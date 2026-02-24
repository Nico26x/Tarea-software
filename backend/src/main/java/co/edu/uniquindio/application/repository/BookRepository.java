package co.edu.uniquindio.application.repository;

import co.edu.uniquindio.application.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

     // Busca por palabra en título o autor (sin importar mayúsculas)
    List<Book> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(String titulo, String autor);
}