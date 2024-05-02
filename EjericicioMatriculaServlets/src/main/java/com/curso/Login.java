package com.curso;

import java.io.IOException;

import com.modelo.Usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// declaraciones
		HttpSession sesion = request.getSession();
		Usuario usuario = null;
		String contraReal = null;
		String nombre;
		String contra;

		// leemos la sesion
		try {

			usuario = (Usuario) sesion.getAttribute("usuario");
			nombre = request.getParameter("userName");
			contra = request.getParameter("userPass");

			contraReal = usuario.getContrasegna();

			if (contra.equals(contraReal)) {
				// Se obtiene el objeto rd para transferir la petición al servlet2
				RequestDispatcher rd = request.getRequestDispatcher("Servlet2");
				// se envía la solicitud al servlet2
				rd.forward(request, response);
			} else {

				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);

			}

		} catch (Exception e) {
			String mensaje = "Error al iniciar sesion";
			response.setContentType("text/html");
			response.getWriter().println("<script type=\"text/javascript\">");
			response.getWriter().println("alert('" + mensaje + "');");
			response.getWriter().println("window.location.href='index.html';");
			response.getWriter().println("</script>");
		}
	}

}
