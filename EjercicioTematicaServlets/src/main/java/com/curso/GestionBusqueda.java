package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class GestionBusqueda
 */
public class GestionBusqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String texto = request.getParameter("textoBusqueda");

		switch (texto) {

		case "musica":
			response.sendRedirect("musica.html");

			break;

		case "juegos":
			response.sendRedirect("juegos.html");
			break;

		case "libros":
			response.sendRedirect("libros.html");
			break;

		default:
			response.sendRedirect("fallo.html");

		}
	}

}
