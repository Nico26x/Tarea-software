package co.edu.uniquindio.application.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "libros")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titulo;

    @Column(unique = true, nullable = false)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonIgnoreProperties("libros")
    private Autor autor;

    @OneToMany(mappedBy = "libro", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("libro")
    private List<Resena> resenas;

    @OneToMany(mappedBy = "libro", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("libro")
    private List<Calificacion> calificaciones;

    public Book() {}

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }

    public List<Calificacion> getCalificaciones() {
    return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
    this.calificaciones = calificaciones;
    }
}