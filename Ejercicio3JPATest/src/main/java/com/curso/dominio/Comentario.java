package com.curso.dominio;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
    private String texto;
    private String autor;
    
    @ManyToOne
    @JoinColumn(name = "id_noticia", referencedColumnName = "titulo")
    private Noticia noticia;

    public Comentario() {
        
    }
    
    public Comentario(int id, String texto, String autor, String id_noticia) {
        this.id = id;
        this.texto = texto;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

 

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", autor='" + autor + '\'' +
      
                '}';
    }
}

