package com.curso;

import java.io.IOException;

import com.modelo.Tematica;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestionBusqueda
 */
public class GestionBusqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String texto = request.getParameter("textoBusqueda");
		Tematica tema = null;

		switch (texto) {

		case "musica":
				tema = new Tematica("¡Bienvenido a la tematica musica!", "Escucha musica con spotify como desees!", "https://open.spotify.com/intl-es/",
						"Spotify", "Quizas algo de Hip Hop Urbano","https://worldstar.com/","WorldStar","Sino prueba algo mas esporadico",
						"https://soundcloud.com/", "SoundCloud");
				request.setAttribute("tematica", tema);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("paginaTematicas.jsp");
			    dispatcher.forward(request, response);
				
			break;

		case "juegos":
				
			tema = new Tematica("¡Bienvenido a la tematica juegos!", "Sumergete en mundos increibles!", "https://worldofwarcraft.blizzard.com/es-es/",
					"World of Warcraft", "Conviertete en un verdadero cow-boy","https://www.rockstargames.com/es/reddeadredemption2","RDR2","Si te gusta alguno los puedes comprar",
					"https://store.steampowered.com/?l=spanish", "Steam");
			request.setAttribute("tematica", tema);
			
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("paginaTematicas.jsp");
		    dispatcher1.forward(request, response);
			break;

		case "libros":
			tema = new Tematica("¡Bienvenido a la tematica libros!", "¡Bienvenido a la tematica libros!", "https://www.casadellibro.com/",
					"Casa del libro", "Echale un vistazo a tu tienda local","https://www.fnac.es/","Fnac","Quizas eres mas de leer online",
					"https://onlinebooks.library.upenn.edu/", "Online Book Pages");
			request.setAttribute("tematica", tema);
			
			RequestDispatcher dispatcher11 = request.getRequestDispatcher("paginaTematicas.jsp");
		    dispatcher11.forward(request, response);
			break;

		default:
			response.sendRedirect("fallo.html");

		}
	}

}
