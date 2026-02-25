package co.edu.uniquindio.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uniquindio.application.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}