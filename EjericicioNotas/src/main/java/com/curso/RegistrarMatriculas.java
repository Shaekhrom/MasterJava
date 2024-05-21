package com.curso;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.modelo.Usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrarMatriculas
 */
public class RegistrarMatriculas extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession sesion = request.getSession(true);
	    sesion.setMaxInactiveInterval(120);
	    Usuario usuario = (Usuario) sesion.getAttribute("usuario");

	    HashMap<String, String> listaNotas = usuario.getAsignaturaYnota();

	    for (int i = 1; i <= 3; i++) {
	        String nombreAsignatura = request.getParameter("nombreAsignatura" + i);
	        String nota = request.getParameter("nota" + i);

	        // Verificar que ambos campos no estén vacíos
	        if (nombreAsignatura != null && !nombreAsignatura.isEmpty() && nota != null && !nota.isEmpty()) {
	            // Agregar la asignatura y la nota al HashMap
	            listaNotas.put(nombreAsignatura, nota);
	        }
	    }

	    usuario.setAsignaturaYnota(listaNotas);
	    sesion.setAttribute("usuario", usuario);

	    String mensaje = "Asignaturas añaadidas con exito";

	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    out.println("<html><body>");
	    out.println("<script type=\"text/javascript\">");
	    out.println("alert('" + mensaje + "');");
	    out.println("window.location.href = 'GestorMatriculas';"); 
	    out.println("</script>");
	    out.println("</body></html>");
	}

}
