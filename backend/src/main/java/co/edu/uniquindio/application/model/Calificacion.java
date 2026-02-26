package co.edu.uniquindio.application.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "calificaciones")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer puntuacion;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    @JsonIgnoreProperties({"calificaciones", "resenas"})
    private Book libro;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Calificacion() {}

    public Integer getId() {
        return id;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Book getLibro() {
        return libro;
    }

    public void setLibro(Book libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

