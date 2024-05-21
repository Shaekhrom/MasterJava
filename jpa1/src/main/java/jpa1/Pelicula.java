package jpa1;

import jakarta.persistence.Entity; 
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name="peliculas")
public class Pelicula {

    @Id
    private int codigo;
    private String titulo;
    private String director;
    private double precio_alquiler;

    public Pelicula() {}

    public Pelicula(String titulo, String director, double precio_alquiler) {
        this.titulo = titulo;
        this.director = director;
        this.precio_alquiler = precio_alquiler;
    }

    // Getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getprecio_alquiler() {
        return precio_alquiler;
    }

    public void setprecio_alquiler(double precio_alquiler) {
        this.precio_alquiler = precio_alquiler;
    }
}

