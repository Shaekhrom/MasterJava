package modelo;

import java.util.ArrayList;

public class Libro {
	//atributos
	private String isbn;
	private String titulo;
	private String autor;
	private int numPaginas;
	
	//variable global para contar numero de libros
	public static int numLibros;
	
	//constructor
	public Libro(String isbn, String titulo, String autor, int numPaginas) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.numPaginas = numPaginas;
		numLibros++;
	}
	
	
	//getters y setters
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		autor = autor;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	//toString
	@Override
	public String toString() {
		return "El libro con ISBN (" + isbn + ") creado por el autor '" + autor + "' tiene " + numPaginas + " paginas";
	}
	
	//comparador
	public static String comparadorPaginas(ArrayList<Libro> libros) {
		Libro libroConMasPaginas = null;
		int paginasMasAltas = 0;
		
		for (Libro libro : libros) {
            if (libro.getNumPaginas() > paginasMasAltas) {
                paginasMasAltas = libro.getNumPaginas();
                libroConMasPaginas = libro;
            }else {
            	return "Hay dos o mas libros iguales";
            }
        }
		return "El libro '" + libroConMasPaginas.getTitulo() + "' es el que mas paginas tiene";
	}
	
}
