package main;

import java.util.ArrayList;

import modelo.Libro;

public class Main {
	//Creado por Alejandro Barbacil

	public static void main(String[] args) {
		
		//Libro 1
		String isbn = "23v49c23j3";
		String titulo = "La pasion de java";
		String autor = "El prohibidisimo";
		int numPaginas = 2345;

		Libro libro1 = new Libro(isbn, titulo, autor, numPaginas);
		
		//Libro 2
		 isbn = "adlkawnd2f3";
		 titulo = "Me encanta ViewNext";
		 autor = "Alejandro el Javero";
		 numPaginas = 369;

		Libro libro2 = new Libro(isbn, titulo, autor, numPaginas);
		
		ArrayList<Libro> libros = new ArrayList<>();
		
		libros.add(libro1);
		libros.add(libro2);
		
		System.out.println("---Lista de libros---");
    	for (Libro libro : libros) {
            System.out.println(libro);
        }
    	
    	//mostrar libro con mas paginas
    	Libro libroConMasPaginas = null;
    	int paginasMasAltas = 0;
    	
    	for (Libro libro : libros) {
            if (libro.getNumPaginas() > paginasMasAltas) {
                paginasMasAltas = libro.getNumPaginas();
                libroConMasPaginas = libro;
            }
        }
    	System.out.println("El libro '" + libroConMasPaginas.getTitulo() + "' es el que mas páginas tiene");

	}

}
